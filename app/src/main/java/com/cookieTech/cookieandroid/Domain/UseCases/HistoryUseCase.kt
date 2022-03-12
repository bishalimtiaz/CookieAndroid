package com.cookieTech.cookieandroid.Domain.UseCases

import com.cookieTech.cookieandroid.Domain.Models.Food
import com.cookieTech.cookieandroid.Domain.Models.FoodHistory
import com.cookieTech.cookieandroid.Domain.Repositories.FoodHistoryRepository
import java.util.*

class HistoryUseCase(
    val historyRepository: FoodHistoryRepository
) {

    fun addFoodToHistory(foodId:Long,mealType:String,quantity:Float,unitId:Int):Long {
        val date = Calendar.getInstance()
        val history = FoodHistory(foodId,date,mealType,quantity,unitId)
        return historyRepository.addFoodToHistory(history)
    }

    fun deleteFoodHistory(foodHistory: FoodHistory):Long{
        return historyRepository.deleteFoodHistory(foodHistory)
    }

}