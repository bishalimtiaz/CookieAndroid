package com.cookieTech.cookieandroid.domain.repositories

import com.cookieTech.cookieandroid.domain.models.FoodHistory

interface FoodHistoryRepository {

    fun addFoodToHistory(history: FoodHistory):Long


    fun deleteFoodHistory(foodHistory: FoodHistory): Long


}