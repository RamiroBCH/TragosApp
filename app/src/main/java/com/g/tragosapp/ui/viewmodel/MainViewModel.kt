package com.g.tragosapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.g.tragosapp.data.model.Drink
import com.g.tragosapp.databinding.FragmentMainBinding
import com.g.tragosapp.databinding.FragmentTragosDetalleBinding
import com.g.tragosapp.domain.Repo
import com.g.tragosapp.vo.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val repo:Repo):ViewModel() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private var _bindingD: FragmentTragosDetalleBinding? = null
    private val bindingD get() = _bindingD!!


    val fetchTragosList = liveData(Dispatchers.IO) {
        emit(Resource.Loading)
        try {
            emit(repo.getTragosList("Margarita"))
        }catch (e:Exception){
            emit(Resource.Failure(e))
        }
    }

    fun setDetails(drink: Drink){
        bindingD.lista.text = drink.strInstructions
    }
}

class VMFactory(private val repo: Repo): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Repo::class.java).newInstance(repo)
    }

}