package com.cookieTech.cookieandroid.domain.models

import androidx.room.*
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
@Entity(
    tableName = "food_table"
)
data class Food(
    @SerialName("id")
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,

    @SerialName("name")
    val name: String?,

    @SerialName("quantity")
    val quantity: Float?,

    @SerialName("unit")
    val unit: Int?,

    @SerialName("fat")
    val fat: Float?,

    @SerialName("protein")
    val protein: Float?,

    @SerialName("carb")
    val carb: Float?,

    @SerialName("fiber")
    val fiber: Float?,

    @SerialName("netCarb")
    val netCarb: Float?,

    @SerialName("calories")
    val calories: Float?,

    var isDeleted:Boolean = false
)


@Entity(tableName = "food_fts")
@Fts4(contentEntity = Food::class)
data class FoodFts(
    @ColumnInfo(name = "name")
    val name: String
)



@Serializable
data class SearchFoodItem(
    @SerialName("id")
    val id:Long,
    @SerialName("name")
    val foodName:String,
    @SerialName("calories")
    val calories:Float?,
    @SerialName("quantity")
    val quantity:Float?,
    @SerialName("unit")
    @Embedded(prefix = "u_")
    val unit:Units?
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
