package com.g.tragosapp.data.model


data class Drink(
    val strDrinkThumb: String = "",
    val strDrink: String = "",
    val strInstructions: String = ""
)

data class DrinkList(
    val drinks:List<Drink>
)
