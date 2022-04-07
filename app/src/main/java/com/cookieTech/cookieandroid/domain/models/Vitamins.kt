package com.cookieTech.cookieandroid.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
@Entity(
    tableName = "vitamins_table",
    foreignKeys = [
        ForeignKey(entity = Food::class,parentColumns = ["id"],childColumns = ["food_id"],onDelete = ForeignKey.CASCADE)
    ]
)
data class Vitamins(
    @SerialName("id")
    @PrimaryKey(autoGenerate = true)
    var id:Int? = 0,

    @ColumnInfo(name = "food_id")
    val foodId: Int?,

    @SerialName("b1ThiamineMg")
    val b1ThiamineMg: Float?,

    @SerialName("b2RiboflavinMg")
    val b2RiboflavinMg: Float?,

    @SerialName("b3NiacinMg")
    val b3NiacinMg: Float?,

    @SerialName("b5PantothenicAcidMg")
    val b5PantothenicAcidMg: Float?,

    @SerialName("b6PyridoxineMg")
    val b6PyridoxineMg: Float?,

    @SerialName("b12CobalaminMicg")
    val b12CobalaminMicg: Float?,

    @SerialName("b7BiotinMg")
    val b7BiotinMg: Float?,

    @SerialName("b8CholineMg")
    val b8CholineMg: Float?,

    @SerialName("b9FolateMicg")
    val b9FolateMicg: Float?,

    @SerialName("vitaminAIU")
    val vitaminAIU: Float?,

    @SerialName("vitaminCMg")
    val vitaminCMg: Float?,

    @SerialName("vitaminDIU")
    val vitaminDIU: Float?,

    @SerialName("vitaminEMg")
    val vitaminEMg: Float?,

    @SerialName("vitaminKMicg")
    val vitaminKMicg: Float?
)
