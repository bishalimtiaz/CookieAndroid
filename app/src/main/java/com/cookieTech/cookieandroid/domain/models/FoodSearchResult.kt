package com.cookieTech.cookieandroid.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class FoodSearchResult(
    val foods: List<Food>
)
