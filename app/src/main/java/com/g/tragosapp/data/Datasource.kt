package com.g.tragosapp.data

import com.g.tragosapp.AppDatabase
import com.g.tragosapp.data.model.Drink
import com.g.tragosapp.data.model.DrinkEntity
import com.g.tragosapp.vo.Resource
import com.g.tragosapp.vo.RetrofitClient

class Datasource(private val appDatabase: AppDatabase){

    suspend fun getTragosByName(tragoName:String):Resource<List<Drink>>{
        val success = Resource.Success(RetrofitClient.webservice.getTragoByName(tragoName).drinks)
        return success
    }

    suspend fun insertTragoIntoRoom(trago:DrinkEntity){
        appDatabase.tragosDao().insertFavorite(trago)
    }

    suspend fun getTragosFavoritos(): Resource<List<DrinkEntity>> {
        return Resource.Success(appDatabase.tragosDao().getAllFavoriteDrinks())
    }
}