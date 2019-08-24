package com.kotlin.demo.project.mvp.category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.demo.project.mvp.R
import kotlinx.android.synthetic.main.adapter_category.view.*

class CategoryAdapter(
    private val models: List<String>
): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    inner class CategoryViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(data: String) {
            with(itemView) {
                tvCategory.text = data
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder =
        CategoryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_category, parent, false)
        )

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(models[position])
    }

    override fun getItemCount(): Int = models.size
}