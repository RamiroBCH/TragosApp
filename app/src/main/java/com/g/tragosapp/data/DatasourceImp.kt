package com.g.tragosapp.data

import com.g.tragosapp.AppDatabase
import com.g.tragosapp.data.model.Drink
import com.g.tragosapp.data.model.DrinkEntity
import com.g.tragosapp.domain.Datasource
import com.g.tragosapp.vo.Resource
import com.g.tragosapp.vo.RetrofitClient

class DatasourceImp(private val appDatabase: AppDatabase):Datasource{

    override suspend fun getTragosByName(tragoName:String):Resource<List<Drink>>{
        val success = Resource.Success(RetrofitClient.webservice.getTragoByName(tragoName).drinks)
        return success
    }

    override suspend fun insertTragoIntoRoom(trago:DrinkEntity){
        appDatabase.tragosDao().insertFavorite(trago)
    }

    override suspend fun getTragosFavoritos(): Resource<List<DrinkEntity>> {
        return Resource.Success(appDatabase.tragosDao().getAllFavoriteDrinks())
    }
}