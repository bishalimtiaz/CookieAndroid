package com.cookieTech.cookieandroid.Domain.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName = "vitamins_table",
    foreignKeys = [
        ForeignKey(entity = Food::class,parentColumns = ["id"],childColumns = ["food_id"],onDelete = ForeignKey.CASCADE)
    ]
)
data class Vitamins(
    @ColumnInfo(name = "food_id")val foodId:Int,
    val b1ThiamineMg:Float,
    val b2RiboflavinMg:Float,
    val b3NiacinMg:Float,
    val b5PantothenicAcidMg:Float,
    val b6PyridoxineMg:Float,
    val b12CobalaminMicg:Float,
    val b7BiotinMg:Float,
    val b8CholineMg:Float,
    val b9FolateMicg:Float,
    val vitaminAIU:Float,
    val vitaminCMg:Float,
    val vitaminDIU:Float,
    val vitaminEMg:Float,
    val vitaminKMicg:Float
){
    @PrimaryKey(autoGenerate = true) var id:Int = 0
}
