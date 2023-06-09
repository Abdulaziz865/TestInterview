package com.example.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.presentation.databinding.ItemFilmsBinding
import com.example.presentation.models.FilmsResponseUi

class FilmsAdapter(private val onClickListener: (id: String) -> Unit) :
    ListAdapter<FilmsResponseUi, FilmsAdapter.DetailFilmsViewHolder>(diffUtil) {

    inner class DetailFilmsViewHolder(private val binding: ItemFilmsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(model: FilmsResponseUi) {
            binding.originalTitle.text = model.originalTitle
            binding.title.text = model.title
        }

        init {
            itemView.setOnClickListener {
                getItem(bindingAdapterPosition)?.apply { onClickListener(id) }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FilmsAdapter.DetailFilmsViewHolder = DetailFilmsViewHolder(
        ItemFilmsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: FilmsAdapter.DetailFilmsViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<FilmsResponseUi>() {
            override fun areItemsTheSame(
                oldItem: FilmsResponseUi,
                newItem: FilmsResponseUi
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: FilmsResponseUi,
                newItem: FilmsResponseUi
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}