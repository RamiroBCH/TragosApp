package com.g.tragosapp.domain

import com.g.tragosapp.data.model.Drink
import com.g.tragosapp.data.model.DrinkEntity
import com.g.tragosapp.vo.Resource
import com.g.tragosapp.vo.RetrofitClient

interface Datasource {
    suspend fun getTragosByName(tragoName:String): Resource<List<Drink>>
    suspend fun insertTragoIntoRoom(trago: DrinkEntity)
    suspend fun getTragosFavoritos(): Resource<List<DrinkEntity>>
}