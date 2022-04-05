package com.cookieTech.cookieandroid.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "minerals_table",
    foreignKeys = [
        ForeignKey(entity = Food::class,parentColumns = ["id"],childColumns = ["food_id"],onDelete = ForeignKey.CASCADE)
    ]
)
data class Minerals(
    @ColumnInfo(name = "food_id")val foodId:Int,
    val	calciumMg:Float,
    val copperMg:Float,
    val ironMg:Float,
    val magnesiumMg:Float,
    val manganeseMg:Float,
    val phosphosusMg:Float,
    val potassiumMgval :Float,
    val seleniumMicg:Float,
    val sodiumMg:Float,
    val zincMg:Float
){
    @PrimaryKey(autoGenerate = true) var id:Int = 0
}
