package com.tareadavid.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.tareadavid.databinding.TareaFilaBinding
import com.tareadavid.model.Resena
import com.tareadavid.ui.home.HomeFragmentDirections

class TareaAdapter : RecyclerView.Adapter<TareaAdapter.HomeViewHolder>() {


    private var listaResena = emptyList<Resena>()

    inner class HomeViewHolder(private val itemBinding: TareaFilaBinding) : RecyclerView.ViewHolder(itemBinding.root) {


        fun bind(resena: Resena) {
            itemBinding.tvNombre.text = resena.nombre
            itemBinding.tvTelefono.text = resena.telefono
            itemBinding.tvWeb.text = resena.web
            itemBinding.tvCalificacion.text = resena.calificacion

        }
    }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
            val itemBinding =
                TareaFilaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return HomeViewHolder(itemBinding)
        }

        override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
            val lista = listaResena[position]
            holder.bind(lista)
        }

        override fun getItemCount(): Int {
            return listaResena.size
        }

        fun setData(resena: List<Resena>) {
            this.listaResena = resena
            notifyDataSetChanged()
        }
    }
