package com.kotlin.demo.project.mvp.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.demo.project.mvp.R
import kotlinx.android.synthetic.main.adapter_main.view.*

class MainAdapter(
    private val models: List<MainModel>,
    private val listener: HomeListener
) : RecyclerView.Adapter<MainAdapter.ListViewHolder>() {
    inner class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(model: MainModel) {
            with(itemView) {
                root_view.setOnClickListener {
                    listener.onClick(model)
                }
                title.text = model.title
                description.text = model.description
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder =
        ListViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_main, parent, false)
        )

    override fun getItemCount(): Int = models.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(models[position])
    }

    interface HomeListener {
        fun onClick(data: MainModel)
    }

}