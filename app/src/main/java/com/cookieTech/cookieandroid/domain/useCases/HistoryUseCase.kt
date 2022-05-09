package com.cookieTech.cookieandroid.domain.useCases

import com.cookieTech.cookieandroid.domain.models.FoodHistory
import com.cookieTech.cookieandroid.domain.repositories.FoodHistoryRepository
import java.util.*

class HistoryUseCase(
    val historyRepository: FoodHistoryRepository
) {

    fun addFoodToHistory(foodId:Long,mealType:String,quantity:Float,unitId:Int):Long {
//        val date = Calendar.getInstance()
//        val history = FoodHistory(foodId,date,mealType,quantity,unitId)
//        return historyRepository.addFoodToHistory(history)
        TODO()
    }

    fun deleteFoodHistory(foodHistory: FoodHistory):Long{
        return historyRepository.deleteFoodHistory(foodHistory)
    }

}