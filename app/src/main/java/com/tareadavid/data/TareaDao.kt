package com.tareadavid.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tareadavid.model.Resena

@Dao
interface TareaDao {

    //Funcion para obtener la lista de lugares
    @Query("select * from RESENAS")
    fun getAllData() : LiveData<List<Resena>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(resena: Resena)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateResena(resena: Resena)

    @Delete
    suspend fun deleteResena(resena: Resena)
}