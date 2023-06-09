package com.example.presentation.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.example.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel> constructor(@LayoutRes layoutId: Int) :
    Fragment(layoutId) {

    abstract val binding: VB
    abstract val viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListeners()
        setupRequests()
        setupSubscribes()
    }

    protected open fun initialize() {

    }

    protected open fun setupListeners() {

    }

    protected open fun setupRequests() {

    }

    protected open fun setupSubscribes() {

    }

    protected open fun <T> Flow<Resource<T>>.subscribes(
        state: ((state: Resource<T>) -> Unit)? = null,
        onFailure: (failure: String) -> Unit,
        onSuccess: ((data: T) -> Unit)
    ) {
        lifecycleScope.launch {
            collect {
                when (it) {
                    is Resource.Failure -> {}
                    is Resource.Loading -> {}
                    is Resource.Success -> {
                        it.data?.let { data ->
                            onSuccess(data)
                        }
                    }
                }
            }
        }
    }
}