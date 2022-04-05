package com.cookieTech.cookieandroid.domain.useCases

import com.cookieTech.cookieandroid.domain.models.Food
import com.cookieTech.cookieandroid.domain.repositories.FoodRepository

class CreateAndUpdateFoodUseCase(
    val foodRepository: FoodRepository
) {

    fun createFood(food: Food):Long{
        return foodRepository.createFood(food)
    }


    fun updateFood(food: Food):Long{
        return foodRepository.updateFood(food)
    }

    fun deleteFood(food:Food):Long{
        return foodRepository.deleteFood(food)
    }


}