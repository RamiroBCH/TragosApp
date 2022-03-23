package com.g.tragosapp.domain

import com.g.tragosapp.data.Datasource
import com.g.tragosapp.data.model.Drink
import com.g.tragosapp.data.model.DrinkEntity
import com.g.tragosapp.vo.Resource

class RepoImpl(private val datasource: Datasource): Repo {

    override suspend fun getTragosList(tragoName: String): Resource<List<Drink>> {
        return datasource.getTragosByName(tragoName)
    }

    override suspend fun getTragosFavoritos(): Resource<List<DrinkEntity>> {
        return datasource.getTragosFavoritos()
    }

    override suspend fun insertTrago(trago: DrinkEntity) {
        datasource.insertTragoIntoRoom(trago)
    }

}