package com.astrodesing.increase.data.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.astrodesing.increase.model.Categorias
import com.astrodesing.increase.model.Ingresos
import com.astrodesing.increase.model.IngresosPorCategoriaDomain


@Entity(tableName = "ingresos")
data class EntitiesIngresos(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
    @ColumnInfo(name = "cantidad", defaultValue = "0") val cantidad: Double,
    @PrimaryKey @ColumnInfo(name = "categoria", defaultValue = "1") val categoryId: Int,
    @ColumnInfo(name = "fecha") val fecha: String
)

fun EntitiesIngresos.toDomain() =
    Ingresos(cantidad = cantidad, categoryId = categoryId, fecha = fecha)

@Entity(tableName = "categorias", indices = [Index(value = ["nombreCategoria"], unique = true)])
data class EntitiesCategorias(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
    @ColumnInfo(
        name = "nombreCategoria",
        defaultValue = "Sin Categoria"
    ) val nombreCategoria: String
)

fun EntitiesCategorias.toDomain() = Categorias(nombreCategoria = nombreCategoria)

data class IngresosPorCategorias(
    @Embedded val categoria: EntitiesCategorias,
    @Relation(
        parentColumn = "categoryId",
        entityColumn = "nombreCategoria"
    )
    val ingresos: List<EntitiesIngresos>
)

