package com.example.myapplicationlibrary.adapter

import com.example.myapplicationlibrary.Model.AddCategoryModel

package com.example.myapplicationlibrary.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationlibrary.databinding.ItemCategoryBinding


class CategoryAdapter(private val categories: List<AddCategoryModel>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(private val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: AddCategoryModel) {
            binding.tvCategoryTitle.text = category.categoryTitle
            // You can also display the list of books if needed
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}