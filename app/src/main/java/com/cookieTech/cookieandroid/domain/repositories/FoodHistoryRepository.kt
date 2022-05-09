package com.cookieTech.cookieandroid.domain.repositories

import com.cookieTech.cookieandroid.domain.models.FoodHistory
import com.cookieTech.cookieandroid.domain.models.SearchFoodItem

interface FoodHistoryRepository {

    fun addFoodToHistory(food: SearchFoodItem):Long


    fun deleteFoodHistory(foodHistory: FoodHistory): Long


}