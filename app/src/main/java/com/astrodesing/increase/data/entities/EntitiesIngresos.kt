package com.astrodesing.increase.data.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.Relation


@Entity(tableName = "ingresos")
data class EntitiesIngresos(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
    @ColumnInfo(name = "cantidad", defaultValue = "0") val cantidad: Double,
    @PrimaryKey @ColumnInfo(name = "categoria", defaultValue = 0) val categoryId: Int,
    @ColumnInfo(name = "fecha") val fecha: String
)

@Entity(tableName = "categorias", indices = [Index(value = ["nombreCategoria"], unique = true)])
data class EntitiesCategorias(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
    @ColumnInfo(name = "nombreCategoria") val nombreCategoria: String
)

data class IngresosPorCategorias(
    @Embedded val entitieIngreso: EntitiesIngresos,
    @Relation(
        parentColumn = "categoryId",
        entityColumn = "nombreCategoria"
    )
    val categorias: List<EntitiesCategorias>
)