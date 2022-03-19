package com.g.tragosapp.domain

import com.g.tragosapp.data.model.Drink
import com.g.tragosapp.vo.Resource

interface Repo {
    fun getTragosList(): Resource<List<Drink>>
}