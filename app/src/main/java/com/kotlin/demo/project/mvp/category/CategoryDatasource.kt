package com.kotlin.demo.project.mvp.category

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CategoryDatasource {
    @GET("list.php")
    fun getCategory(
        @Query("c") category: String = "list"
    ): Single<CategoryResponse>
}