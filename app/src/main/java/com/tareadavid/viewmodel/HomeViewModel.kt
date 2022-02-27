package com.tareadavid.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.tareadavid.data.TareaDatabase
import com.tareadavid.model.Resena
import com.tareadavid.repository.TareaRepositorio
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    val getAllData : LiveData<List<Resena>>
    private val repository: TareaRepositorio

    init{
        val tareaDao = TareaDatabase.getDatBase(application).TareaDao()
        repository = TareaRepositorio(tareaDao)
        getAllData = repository.getAllData
    }
    fun add(resena: Resena){

        viewModelScope.launch(Dispatchers.IO) {repository.add(resena)}
    }

    fun updateResena(resena: Resena){
        viewModelScope.launch(Dispatchers.IO) {repository.updateResena(resena)}
    }

    fun deleteResena(resena: Resena) {
        viewModelScope.launch(Dispatchers.IO) {repository.deleteResena(resena)}
    }

}