package com.cookieTech.cookieandroid.Domain.Repositories

import com.cookieTech.cookieandroid.Domain.Models.FoodHistory

interface FoodHistoryRepository {

    fun addFoodToHistory(history: FoodHistory):Long


    fun deleteFoodHistory(foodHistory: FoodHistory): Long


}