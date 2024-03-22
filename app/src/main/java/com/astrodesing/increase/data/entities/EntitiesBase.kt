package com.astrodesing.increase.data.entities


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.astrodesing.increase.model.Base

@Entity(tableName = "base_data")
data class EntitiesBase(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
    @ColumnInfo(name = "first_name", defaultValue = "Empty") val userName: String,
    @ColumnInfo(name = "age", defaultValue = "18") val userAge: Int,
    @ColumnInfo(name = "first_init_aplication", defaultValue = "false") val userFirstInit: Boolean
)

fun Base.todatabase() = EntitiesBase(userName = userName, userAge = userAge,userFirstInit = userFirstInit)