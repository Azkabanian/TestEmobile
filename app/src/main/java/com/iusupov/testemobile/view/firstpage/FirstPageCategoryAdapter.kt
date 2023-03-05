package com.iusupov.testemobile.view.firstpage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.iusupov.domain.model.LatestDomainModule
import com.iusupov.testemobile.databinding.ItemLatestBinding

class FirstPageCategoryAdapter : RecyclerView.Adapter<FirstPageCategoryAdapter.LatestViewHolder>() {

    inner class LatestViewHolder(val binding: ItemLatestBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(latest: LatestDomainModule?) {
            binding.apply {
                Glide.with(this.root).load(latest?.image_url).into(ivLatest)
                tvName.text = latest?.name
                tvCategory.text = latest?.category
                tvPrice.text = latest?.price.toString()
            }
        }
        }

    private val differCallback = object : DiffUtil.ItemCallback<LatestDomainModule>() {

        override fun areItemsTheSame(
            oldItem: LatestDomainModule, newItem: LatestDomainModule
        ) = oldItem.image_url == newItem.image_url

        override fun areContentsTheSame(
            oldItem: LatestDomainModule, newItem: LatestDomainModule
        ) = oldItem == newItem
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestViewHolder {
        val binding = ItemLatestBinding
            .inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return LatestViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LatestViewHolder, position: Int) {
        val currentItem = differ.currentList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount() = differ.currentList.size
}