package com.g.tragosapp.domain

import com.g.tragosapp.data.DatasourceImp
import com.g.tragosapp.data.model.Drink
import com.g.tragosapp.data.model.DrinkEntity
import com.g.tragosapp.vo.Resource

class RepoImpl(private val datasourceImp: DatasourceImp): Repo {

    override suspend fun getTragosList(tragoName: String): Resource<List<Drink>> {
        return datasourceImp.getTragosByName(tragoName)
    }

    override suspend fun getTragosFavoritos(): Resource<List<DrinkEntity>> {
        return datasourceImp.getTragosFavoritos()
    }

    override suspend fun insertTrago(trago: DrinkEntity) {
        datasourceImp.insertTragoIntoRoom(trago)
    }

}