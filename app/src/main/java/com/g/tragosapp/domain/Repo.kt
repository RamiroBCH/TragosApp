package com.g.tragosapp.domain

import com.g.tragosapp.data.model.Drink
import com.g.tragosapp.data.model.DrinkEntity
import com.g.tragosapp.vo.Resource

interface Repo {
    suspend fun getTragosList(tragoName: String): Resource<List<Drink>>
    suspend fun getTragosFavoritos(): Resource<List<DrinkEntity>>
    suspend fun insertTrago(trago:DrinkEntity)
}