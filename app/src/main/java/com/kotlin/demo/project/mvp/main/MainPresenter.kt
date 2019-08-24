package com.kotlin.demo.project.mvp.main

class MainPresenter(private val view: MainView) {
    fun showModel() {
        val models = mutableListOf<MainModel>()
        for (model in 0 until 30) {
            models.add(MainModel("Tes $model", "Contoh model ke-$model"))
        }

        view.showData(models)
    }
}