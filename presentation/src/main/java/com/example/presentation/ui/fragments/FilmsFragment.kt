package com.example.presentation.ui.fragments

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentFilmsBinding
import com.example.presentation.state.UIState
import com.example.presentation.ui.adapters.FilmsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FilmsFragment : BaseFragment<FragmentFilmsBinding, FilmsViewModel>(R.layout.fragment_films) {

    override val binding by viewBinding(FragmentFilmsBinding::bind)
    override val viewModel: FilmsViewModel by viewModels()
    private val filmsAdapter = FilmsAdapter(this::onClickItem)

    override fun initialize() {
        binding.rvListOfFilms.adapter = filmsAdapter
    }

    override fun setupListeners() {
    }

    override fun setupSubscribes() {
        subscribesToPopularVideos()
    }

    private fun subscribesToPopularVideos() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.filmsState.collect { uiState ->
                    when (uiState) {
                        is UIState.Error -> {
                            Log.e("error" , uiState.error)
                        }
                        is UIState.Loading -> {
                            Log.e("load" , "LOADING")
                        }
                        is UIState.Success -> {
                            Log.e("success" , "SUCCESS!!!")
                            filmsAdapter.submitList(uiState.data)
                        }
                    }
                }
            }
        }
    }

    private fun onClickItem(id: String) {
        findNavController().navigate(FilmsFragmentDirections.actionFilmsFragmentToDetailFilmsFragment(id))
    }
}