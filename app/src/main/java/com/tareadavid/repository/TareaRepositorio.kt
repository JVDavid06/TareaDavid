package com.tareadavid.repository

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.tareadavid.data.TareaDao
import com.tareadavid.model.Resena


class TareaRepositorio(private val tareaDao: TareaDao) {

    val getAllData : LiveData<List<Resena>> = tareaDao.getAllData()

    suspend fun add(resena: Resena){
        tareaDao.add(resena)
    }

    suspend fun updateResena(resena: Resena){
        tareaDao.updateResena(resena)
    }

    suspend fun deleteResena(resena: Resena){
        tareaDao.deleteResena(resena)
    }
}