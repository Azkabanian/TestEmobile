package com.iusupov.testemobile.view.firstpage

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iusupov.testemobile.databinding.ItemCategoryBinding

class FirstPageCategoryAdapter: RecyclerView.Adapter<FirstPageCategoryAdapter.CategoryListViewHolder>(){

    inner class CategoryListViewHolder(val binding: ItemCategoryBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryListViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CategoryListViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}