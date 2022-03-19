package com.g.tragosapp.domain

import com.g.tragosapp.data.Datasource
import com.g.tragosapp.data.model.Drink
import com.g.tragosapp.vo.Resource

class RepoImpl(private val datasource: Datasource): Repo {

    override fun getTragosList(): Resource<List<Drink>> {
        return datasource.generateTragosList
    }

}