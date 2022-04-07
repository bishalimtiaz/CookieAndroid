package com.cookieTech.cookieandroid.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "units_table")
data class Units(

    @SerialName("id")
    @PrimaryKey(autoGenerate = true)
    var id: Int? = 0,

    @SerialName("unit_name")
    val unit_name: String?,

    @SerialName("unit_symbol")
    val unit_symbol: String?,

    @SerialName("unit_category")
    val unit_category: String?
)
