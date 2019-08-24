package com.kotlin.demo.project.mvp.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.demo.project.mvp.R
import com.kotlin.demo.project.mvp.main.MainModel
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), DetailView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val model = intent.getParcelableExtra<MainModel>("HOME")
        val presenter = DetailPresenter(this)
        presenter.showModel(model)
    }

    override fun showModel(data: DetailModel) {
        tv_detail.text = data.description
    }
}