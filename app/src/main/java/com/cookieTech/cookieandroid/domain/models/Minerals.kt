package com.cookieTech.cookieandroid.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Entity(
    tableName = "minerals_table",
    foreignKeys = [
        ForeignKey(entity = Food::class,parentColumns = ["id"],childColumns = ["food_id"],onDelete = ForeignKey.CASCADE)
    ]
)
data class Minerals(

    @SerialName("id")
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,


    @ColumnInfo(name = "food_id")
    val foodId:Int,

    @SerialName("calciumMg")
    val	calciumMg: Float?,

    @SerialName("copperMg")
    val copperMg: Float?,

    @SerialName("ironMg")
    val ironMg: Float?,

    @SerialName("magnesiumMg")
    val magnesiumMg: Float?,

    @SerialName("manganeseMg")
    val manganeseMg: Float?,

    @SerialName("phosphosusMg")
    val phosphosusMg: Float?,

    @SerialName("potassiumMgval")
    val potassiumMgval: Float?,

    @SerialName("seleniumMicg")
    val seleniumMicg: Float?,

    @SerialName("sodiumMg")
    val sodiumMg: Float?,

    @SerialName("zincMg")
    val zincMg: Float?
)
