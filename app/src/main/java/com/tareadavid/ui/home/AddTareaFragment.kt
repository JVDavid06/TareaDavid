package com.tareadavid.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.tareadavid.R
import com.tareadavid.databinding.FragmentAddTareaBinding
import com.tareadavid.databinding.FragmentHomeBinding
import com.tareadavid.model.Resena
import com.tareadavid.viewmodel.HomeViewModel





class AddTareaFragment : Fragment() {
    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentAddTareaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddTareaBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun agregarResena() {
        val nombre=binding.etNombre.text.toString()
        if (nombre.isNotEmpty()){
            val telefono=binding.etTelefono.text.toString()
            val web=binding.etWeb.text.toString()
            val calificacion= binding.etCalificacion.text.toString()
            val resena= Resena(0,"","","","")
            homeViewModel.add(resena)
            Toast.makeText(requireContext(),getString(R.string.msg_resena_add), Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addTareaFragment_to_nav_home)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}