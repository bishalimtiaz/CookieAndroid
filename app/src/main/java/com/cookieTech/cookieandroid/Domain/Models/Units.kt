package com.cookieTech.cookieandroid.Domain.Models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "units_table")
data class Units(
    val unit_name:String,
    val unit_symbol:String,
    val unit_category:String
){
    @PrimaryKey(autoGenerate = true)var id:Int = 0
}
