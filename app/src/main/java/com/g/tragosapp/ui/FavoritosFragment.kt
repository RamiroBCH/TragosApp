package com.g.tragosapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.g.tragosapp.AppDatabase
import com.g.tragosapp.R
import com.g.tragosapp.data.DatasourceImp
import com.g.tragosapp.data.model.Drink
import com.g.tragosapp.databinding.FragmentFavoritosBinding
import com.g.tragosapp.databinding.FragmentMainBinding
import com.g.tragosapp.domain.RepoImpl
import com.g.tragosapp.ui.viewmodel.MainViewModel
import com.g.tragosapp.ui.viewmodel.VMFactory
import com.g.tragosapp.vo.Resource


class FavoritosFragment : Fragment(), MainAdapter.OnTragoClickListener {

    private val viewModel by activityViewModels<MainViewModel> {
        VMFactory(RepoImpl(DatasourceImp(AppDatabase.getDatabase(requireActivity().applicationContext))))
    }

    private var _binding: FragmentFavoritosBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoritosBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRV()
        setupObservers()

    }

    private fun setupObservers(){
        viewModel.getTragosFavoritos().observe(viewLifecycleOwner, Observer {result ->
            when(result){
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    val lista: List<Drink> = result.data.map{
                        Drink(it.idDrink,it.imagen,it.nombre,it.descripcion)
                    }
                    binding.rvTragosFavoritos.adapter = MainAdapter(requireContext(),lista,this)
                    binding.progressBar.visibility = View.GONE
                }
                is Resource.Failure -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), "Error ${result.exception}", Toast.LENGTH_SHORT ).show()
                }
            }
        })
    }

    private fun setupRV(){
        binding.rvTragosFavoritos.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTragosFavoritos.addItemDecoration(DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL))
    }

    override fun onTragoClick(drink: Drink) {
        viewModel.setDrink(drink)
        val action = FavoritosFragmentDirections.actionFavoritosFragmentToTragosDetalleFragment()
        findNavController().navigate(action)
    }
}