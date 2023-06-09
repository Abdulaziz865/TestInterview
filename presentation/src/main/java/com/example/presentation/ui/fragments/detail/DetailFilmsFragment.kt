package com.example.presentation.ui.fragments.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentDetailFilmsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFilmsFragment : BaseFragment<FragmentDetailFilmsBinding, DetailFilmsViewModel>(R.layout.fragment_detail_films) {

    override val binding by viewBinding(FragmentDetailFilmsBinding::bind)
    override val viewModel: DetailFilmsViewModel by viewModels()
    private val navArgs by navArgs<DetailFilmsFragmentArgs>()

    override fun setupSubscribes() {
        subscribeToFilmsDetail()
    }

    private fun subscribeToFilmsDetail() = with(binding) {
        viewModel.fetchDetailFilmById(navArgs.id).subscribes(
            onFailure = {

            },
            onSuccess = { data ->
                data.image.let {
                    Glide.with(image.context).load(it)
                        .into(image)
                }
                title.text = data.title
                originalTitle.text = data.originalTitle

            }
        )
    }
}