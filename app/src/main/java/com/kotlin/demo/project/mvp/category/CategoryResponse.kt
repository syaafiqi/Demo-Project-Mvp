package com.kotlin.demo.project.mvp.category

import kotlinx.serialization.Serializable

@Serializable
data class CategoryResponse (
    val drinks: List<Drinks>
)

@Serializable
data class Drinks (
    val strCategory: String
)