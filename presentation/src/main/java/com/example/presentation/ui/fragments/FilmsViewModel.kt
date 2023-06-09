package com.example.presentation.ui.fragments

import androidx.lifecycle.viewModelScope
import com.example.domain.models.FilmsResponse
import com.example.domain.usecases.FetchFilmsUseCase
import com.example.domain.utils.Either
import com.example.presentation.base.BaseViewModel
import com.example.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilmsViewModel @Inject constructor(private val fetchFilmsUseCase: FetchFilmsUseCase) : BaseViewModel() {

    private val _filmsState = MutableStateFlow<UIState<List<FilmsResponse>>>(UIState.Loading())
    val filmsState = _filmsState.asStateFlow()

    init {
       fetchFilms()
    }

    private fun fetchFilms() {
        viewModelScope.launch {
            fetchFilmsUseCase.invoke("", 50).collect { either ->
                when (either) {
                    is Either.Left -> {
                        _filmsState.value = UIState.Error(either.message ?: "Error!!!")
                    }
                    is Either.Right -> {
                        either.data?.let { films ->
                            _filmsState.value = UIState.Success(films)
                        }
                    }
                }
            }
        }
    }
}