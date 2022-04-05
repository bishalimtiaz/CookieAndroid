package com.cookieTech.cookieandroid.domain.models

import androidx.room.*


@Entity(
    tableName = "food_table"
)
data class Food(
    val name:String,
    val quantity:Float,
    val unit:Int,
    val fat:Float,
    val protein:Float,
    val carb:Float,
    val fiber:Float,
    val netCarb:Float,
    val calories:Float
){
    @PrimaryKey(autoGenerate = true) var id:Long = 0
    var isDeleted:Boolean = false


}


@Entity(tableName = "food_fts")
@Fts4(contentEntity = Food::class)
data class FoodFts(
    @ColumnInfo(name = "name")
    val name: String
)



data class SearchFoodItem(
    val id:Long,
    val foodName:String,
    val calories:Float,
    val quantity:Float,
    val unit:String
)

data class SearchFoodItemWithMathInfo(
    @Embedded
    val food: SearchFoodItem,
    @ColumnInfo(name = "matchInfo")
    val matchInfo: ByteArray
) {

    // We need to override equals and hashcode due to the presence of an array property in the data class
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SearchFoodItemWithMathInfo

        if (food != other.food) return false
        if (!matchInfo.contentEquals(other.matchInfo)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = food.hashCode()
        result = 31 * result + matchInfo.contentHashCode()
        return result
    }
}


class FoodWithVitaminsAndMinerals(
    @Embedded
    val food:Food,

    @Relation(parentColumn = "id",entityColumn = "food_id")
    val vitamins:Vitamins,

    @Relation(parentColumn = "id",entityColumn = "food_id")
    val minerals:Vitamins
) {


}
