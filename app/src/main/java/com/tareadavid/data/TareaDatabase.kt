package com.tareadavid.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tareadavid.model.Resena
import java.security.AccessControlContext
import kotlin.contracts.Returns

@Database(entities = [Resena::class], version = 1, exportSchema = false)

abstract class TareaDatabase : RoomDatabase() {
    abstract fun TareaDao() : TareaDao


    companion object{
        @Volatile
        private var INSTANCE: TareaDatabase? = null

        fun getDatBase(context: android.content.Context) : TareaDatabase{
            var instance = INSTANCE
            if (instance != null){
                return instance
            }
            synchronized(this){

                val basedatos = Room.databaseBuilder(
                    context.applicationContext,
                    TareaDatabase::class.java,
                    "Resena_database"
                ).build()
                INSTANCE = basedatos
                return basedatos
            }
        }
    }

}