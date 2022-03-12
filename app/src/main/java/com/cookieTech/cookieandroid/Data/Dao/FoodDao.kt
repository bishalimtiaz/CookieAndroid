package com.cookieTech.cookieandroid.Data.Dao

import androidx.room.*
import com.cookieTech.cookieandroid.Domain.Models.*
import kotlinx.coroutines.flow.Flow
import kotlin.math.min

@Dao
abstract class FoodDao: BaseDao<Food>() {


    @Query("select * from food_table")
    abstract fun getAllFood(): Flow<List<Food>>


    @Query("select * from food_table where id == :id")
    abstract fun getFoodById(id:Int):Flow<Food>



    @Query("select id,food_table.name as foodName,calories,quantity,unit from food_table join food_fts on food_table.name = food_fts.name where food_fts match :query ")
    abstract fun searchFoodMinimal(query: String): Flow<List<SearchFoodItem>>

    @Query("select id,food_table.name as foodName,calories,quantity,unit,matchinfo(food_fts) as matchInfo from food_table join food_fts on food_table.name = food_fts.name where food_fts match :query ")
    abstract fun searchFoodMinimalWithMatchInfo(query: String): Flow<List<SearchFoodItemWithMathInfo>>

    @Query("""
        select * from food_table where id= :id
    """
    )
    abstract fun getFoodDetailsById(id: Long): Flow<FoodWithVitaminsAndMinerals>


}