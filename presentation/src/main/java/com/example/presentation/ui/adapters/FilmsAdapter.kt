package com.example.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.FilmsResponse
import com.example.presentation.databinding.ItemFilmsBinding

class FilmsAdapter(private val onClickListener: (id: String) -> Unit) : ListAdapter<FilmsResponse, FilmsAdapter.DetailFilmsViewHolder>(diffUtil) {

    inner class DetailFilmsViewHolder(private val binding: ItemFilmsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(model: FilmsResponse) {
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
        val diffUtil = object : DiffUtil.ItemCallback<FilmsResponse>() {
            override fun areItemsTheSame(oldItem: FilmsResponse, newItem: FilmsResponse): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: FilmsResponse, newItem: FilmsResponse): Boolean {
                return oldItem == newItem
            }
        }
    }
}