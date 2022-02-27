package com.tareadavid.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tareadavid.R
import com.tareadavid.adapter.TareaAdapter
import com.tareadavid.databinding.FragmentHomeBinding
import com.tareadavid.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var  homeViewModel : HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.fpButton.setOnClickListener{
            findNavController().navigate(R.id.action_nav_home_to_addTareaFragment)
        }

        //Activar el recycler view
        val tareaAdapter = TareaAdapter()
        val reciclador = binding.reciclador

        reciclador.adapter = tareaAdapter
        reciclador.layoutManager = LinearLayoutManager(requireContext())

        homeViewModel.getAllData.observe(viewLifecycleOwner){resenas -> //ejecuta codigo cuando se actualiza algo
            tareaAdapter.setData(resenas)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}