package com.g.tragosapp.domain

import com.g.tragosapp.data.model.Drink
import com.g.tragosapp.data.model.DrinkList
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("search.php")
    suspend fun getTragoByName(@Query("s") tragoName:String): DrinkList

}