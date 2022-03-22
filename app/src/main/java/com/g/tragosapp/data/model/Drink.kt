package com.g.tragosapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


data class Drink(
    val idDrink: String = "",
    val strDrinkThumb: String = "",
    val strDrink: String = "",
    val strInstructions: String = ""
)

data class DrinkList(
    val drinks:List<Drink>
)


@Entity(tableName = "tragosEntity")
data class DrinkEntity(
    @PrimaryKey
    val idDrink: String,
    @ColumnInfo(name = "trago_imagen")
    val imagen: String ="" ,
    @ColumnInfo(name = "trago_nombre")
    val nombre: String = "",
    @ColumnInfo(name = "trago_descripcion")
    val descripcion: String = ""
)