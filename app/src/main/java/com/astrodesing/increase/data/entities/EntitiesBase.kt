package com.astrodesing.increase.data.entities


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "base_data")
data class EntitiesBase(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "first_name", defaultValue = "Empty") val userName: String,
    @ColumnInfo(name = "age", defaultValue = "18") val userAge: Int,
    @ColumnInfo(name = "first_init_aplication", defaultValue = "false") val userFirstInit: Boolean
)