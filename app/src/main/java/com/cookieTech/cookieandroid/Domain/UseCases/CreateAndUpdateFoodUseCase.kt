package com.cookieTech.cookieandroid.Domain.UseCases

import com.cookieTech.cookieandroid.Domain.Models.Food
import com.cookieTech.cookieandroid.Domain.Models.FoodWithVitaminsAndMinerals
import com.cookieTech.cookieandroid.Domain.Repositories.FoodRepository

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