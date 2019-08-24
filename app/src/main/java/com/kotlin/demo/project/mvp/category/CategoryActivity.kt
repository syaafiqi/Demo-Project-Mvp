package com.kotlin.demo.project.mvp.category

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.demo.project.mvp.R
import kotlinx.android.synthetic.main.activity_category.*

class CategoryActivity: AppCompatActivity(), CategoryView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        supportActionBar?.title = getString(R.string.app_name)

        val presenter = CategoryPresenter(this)
        presenter.getCategory()
    }

    override fun showCategory(model: CategoryModel) {
        rvCategory.adapter = CategoryAdapter(model.categories)
    }

    override fun onLoadingStart() {
        progressBar.visibility = View.VISIBLE
    }

    override fun onLoadingFinish() {
        progressBar.visibility = View.GONE
    }
}