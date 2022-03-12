package com.cookieTech.cookieandroid.Domain.Models

import androidx.room.*
import java.util.*


@Entity(
    tableName = "food_history_table",
    foreignKeys = [
        ForeignKey(entity = Food::class,parentColumns = ["id"],childColumns = ["food_id"]),
        ForeignKey(entity = Units::class,parentColumns = ["id"],childColumns = ["unit_id"])
    ],
    indices = [Index("date","meal_type")]
)
data class FoodHistory(
    @ColumnInfo(name = "food_id")
    val foodId:Long,
    val date:Calendar = Calendar.getInstance(),
    @ColumnInfo(name = "meal_type")
    val mealType:String,
    val quantity:Float,
    @ColumnInfo(name = "unit_id")
    val unitId:Int
){
    @PrimaryKey(autoGenerate = true) var id:Long = 0
}



/**
 * This class captures the relationship between a [Food] and a user's [FoodHistory], which is
 * used by Room to fetch the related entities.
 * One to One Relationship
 */
data class FoodHistoryAndFood(
    @Embedded // parent
    val foodHistory: FoodHistory,

    @Relation(parentColumn = "food_id",entityColumn = "id")
    val food:Food
) {

}



