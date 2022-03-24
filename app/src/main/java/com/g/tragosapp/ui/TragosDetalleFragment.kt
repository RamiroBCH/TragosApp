package com.g.tragosapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.g.tragosapp.AppDatabase
import com.g.tragosapp.R
import com.g.tragosapp.data.DatasourceImp
import com.g.tragosapp.data.model.Drink
import com.g.tragosapp.data.model.DrinkEntity
import com.g.tragosapp.databinding.FragmentTragosDetalleBinding
import com.g.tragosapp.domain.RepoImpl
import com.g.tragosapp.ui.viewmodel.MainViewModel
import com.g.tragosapp.ui.viewmodel.VMFactory

class TragosDetalleFragment : Fragment() {

    private val viewModel by activityViewModels<MainViewModel> {
        VMFactory(RepoImpl(DatasourceImp(AppDatabase.getDatabase(requireActivity().applicationContext))))
    }
    //private val navigationArgs: TragosDetalleFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_tragos_detalle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentTragosDetalleBinding.bind(view)
        var trago: Drink = viewModel.bebida
        Glide.with(requireContext()).load(trago.strDrinkThumb).centerCrop().into(binding.imgTrago)
        binding.tragoTitle.text = trago.strDrink
        binding.tragoDesc.text = trago.strInstructions

        binding.btnGuardar.setOnClickListener{
            viewModel.guardarTrago(DrinkEntity
                (trago.idDrink,trago.strDrinkThumb,trago.strDrink,trago.strInstructions))
            Toast.makeText(requireContext(),"Guardado en Favoritos",Toast.LENGTH_SHORT).show()
        }


    }


    override fun onDestroyView() {
        super.onDestroyView()
    }
}