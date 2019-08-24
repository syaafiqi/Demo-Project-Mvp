package com.kotlin.demo.project.mvp.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.demo.project.mvp.R
import com.kotlin.demo.project.mvp.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView, MainAdapter.HomeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter = MainPresenter(this)
        presenter.showModel()
    }

    override fun showData(models: List<MainModel>) {
        Log.d(MainActivity::class.java.simpleName, "${models.size}")

        rvMain.adapter = MainAdapter(models, this)
    }

    override fun onClick(data: MainModel) {
        Log.d(MainActivity::class.java.simpleName, data.toString())

        startActivity(
            Intent(this, DetailActivity::class.java).apply {
                putExtra("HOME", data)
            }
        )
    }
}
