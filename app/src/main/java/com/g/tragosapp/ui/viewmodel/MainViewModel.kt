package com.g.tragosapp.ui.viewmodel

import android.widget.Toast
import android.widget.Toast.makeText
import androidx.lifecycle.*
import com.g.tragosapp.R
import com.g.tragosapp.data.model.Drink
import com.g.tragosapp.databinding.FragmentMainBinding
import com.g.tragosapp.databinding.FragmentTragosDetalleBinding
import com.g.tragosapp.domain.Repo
import com.g.tragosapp.ui.MainFragment
import com.g.tragosapp.vo.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainViewModel(private val repo:Repo):ViewModel() {

    private val tragosData = MutableLiveData<String>()

    fun setTrago(tragoName: String){
        tragosData.value = tragoName
    }
    init {
        setTrago("margarita")
    }
    val fetchTragosList = tragosData.distinctUntilChanged().switchMap { nombreTrago ->
        liveData(Dispatchers.IO) {
            emit(Resource.Loading)
            try {
                emit(repo.getTragosList(nombreTrago))
            }catch (e:Exception){
                emit(Resource.Failure(e))
            }
        }
    }
}

class VMFactory(private val repo: Repo): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Repo::class.java).newInstance(repo)
    }

}