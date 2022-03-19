package com.g.tragosapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.g.tragosapp.R
import com.g.tragosapp.data.Datasource
import com.g.tragosapp.databinding.FragmentMainBinding
import com.g.tragosapp.databinding.FragmentTragosDetalleBinding
import com.g.tragosapp.domain.RepoImpl
import com.g.tragosapp.ui.viewmodel.MainViewModel
import com.g.tragosapp.ui.viewmodel.VMFactory

class TragosDetalleFragment : Fragment() {
    private val viewModel by activityViewModels<MainViewModel> {
        VMFactory(RepoImpl(Datasource()))
    }
    private var _binding: FragmentTragosDetalleBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tragos_detalle, container, false)
    }
}