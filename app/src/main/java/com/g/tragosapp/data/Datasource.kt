package com.g.tragosapp.data

import com.g.tragosapp.data.model.Drink
import com.g.tragosapp.vo.Resource
import com.g.tragosapp.vo.RetrofitClient

class Datasource {

    suspend fun getTragosByName(tragoName:String):Resource<List<Drink>>{
        val success = Resource.Success(RetrofitClient.webservice.getTragoByName(tragoName).drinks)
        return success
    }
}