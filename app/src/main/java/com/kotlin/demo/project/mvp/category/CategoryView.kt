package com.kotlin.demo.project.mvp.category

interface CategoryView {
    fun onLoadingStart()
    fun onLoadingFinish()
    fun showCategory(model: CategoryModel)
}