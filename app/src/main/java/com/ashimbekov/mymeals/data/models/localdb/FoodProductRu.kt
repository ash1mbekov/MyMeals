package com.ashimbekov.mymeals.data.models.localdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food_ru")
data class FoodProductRu(
    @PrimaryKey
    @ColumnInfo(name = "id") override var id: Int,
    @ColumnInfo(name = "name") override val name: String,
    @ColumnInfo(name = "weight", typeAffinity = ColumnInfo.REAL) val weight: Float,
    @ColumnInfo(name = "proteins", typeAffinity = ColumnInfo.REAL) override val proteins: Float,
    @ColumnInfo(name = "fats", typeAffinity = ColumnInfo.REAL) override val fats: Float,
    @ColumnInfo(name = "carbs", typeAffinity = ColumnInfo.REAL) override val carbs: Float,
    @ColumnInfo(name = "calories", typeAffinity = ColumnInfo.REAL) override val calories: Float
): IProduct

interface IProduct {
    val name: String
    val proteins: Float
    val fats: Float
    val carbs: Float
    val calories: Float
    var id: Int
}
