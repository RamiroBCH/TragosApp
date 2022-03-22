package com.g.tragosapp.domain

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.g.tragosapp.data.model.DrinkEntity

interface TragosDao {
    @Query("SELECT * FROM tragosEntity")
    suspend fun getAllFavoriteDrinks():List<DrinkEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE )
    suspend fun insertFavorite(trago: DrinkEntity)

}