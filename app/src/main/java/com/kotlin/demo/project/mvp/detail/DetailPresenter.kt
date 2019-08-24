package com.kotlin.demo.project.mvp.detail

import com.kotlin.demo.project.mvp.main.MainModel

class DetailPresenter(private val view: DetailView) {
    fun showModel(mainModel: MainModel) {
        val detailModel = DetailModel(mainModel.description)
        view.showModel(detailModel)
    }
}