package com.kotlin.demo.project.mvp.category

import android.util.Log
import com.kotlin.demo.project.mvp.config.NetworkProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryPresenter(
    private val view: CategoryView
) {
    fun getCategory() {
        view.onLoadingStart()
        NetworkProvider.providesRetrofitCocktailDB().create(CategoryDatasource::class.java)
            .getCategory()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({response ->
                view.onLoadingFinish()
                    val model = CategoryModel(response.drinks.map { it.strCategory })
                    view.showCategory(model)
            },{
                Log.d(CategoryPresenter::class.java.simpleName, it.message)
            }).addTo(CompositeDisposable())
//            .enqueue(object : Callback<CategoryResponse> {
//                override fun onResponse(
//                    call: Call<CategoryResponse>,
//                    response: Response<CategoryResponse>
//                ) {
//                    view.onLoadingFinish()
//                    val body = response.body()?.drinks ?: emptyList()
//                    val model = CategoryModel(body.map { it.strCategory })
//                    view.showCategory(model)
//                }
//
//                override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
//                    view.onLoadingFinish()
//                    Log.d(CategoryPresenter::class.java.simpleName, t.message)
//                }
//            })
    }
}