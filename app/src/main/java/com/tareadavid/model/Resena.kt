package com.tareadavid.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "Resenas")
data class Resena(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "nombre")
    val nombre : String,
    @ColumnInfo(name = "telefono")
    val telefono : String?,
    @ColumnInfo(name = "web")
    val web : String?,
    @ColumnInfo(name = "calificacion")
    val calificacion : String?
) : Parcelable

