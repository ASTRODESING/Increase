package com.astrodesing.increase.data.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.astrodesing.increase.model.Categorias
import com.astrodesing.increase.model.Ingresos


@Entity(tableName = "ingresos")
data class EntitiesIngresos(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @ColumnInfo(name = "cantidad", defaultValue = "0") val cantidad: Double,
    @ColumnInfo(name = "categoria", defaultValue = "0") val categoryId: Int,
    @ColumnInfo(name = "descripción", defaultValue = "Sin descripción") val description: String,
    @ColumnInfo(name = "fecha") val fecha: String,
    @ColumnInfo(name = "modalidad", defaultValue = "0") val modalidad: String,
    @ColumnInfo(name = "diasDeLaSemana") val diasDeLaSemana: String
)


fun EntitiesIngresos.toDomain() =
    Ingresos(
        cantidad = cantidad,
        categoryId = categoryId,
        description = description,
        fecha = fecha,
        modalidad = modalidad,
        diasDeLaSemana = diasDeLaSemana
    )

@Entity(tableName = "categorias", indices = [Index(value = ["nombreCategoria"], unique = true)])
data class EntitiesCategorias(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int?,
    @ColumnInfo(name = "nombreCategoria") val nombreCategoria: String
)

fun EntitiesCategorias.toDomain() = Categorias(nombreCategoria = nombreCategoria)


data class IngresosPorCategorias(
    @Embedded val categoria: EntitiesCategorias,
    @Relation(
        parentColumn = "id",
        entityColumn = "categoria",
    )
    val ingresos: List<EntitiesIngresos>
)

data class IngresosPorModalidad(
    @Embedded val modalidad: EntitiesModalidades,
    @Relation(
        parentColumn = "id",
        entityColumn = "modalidad",
    )
    val ingresos: List<EntitiesIngresos>
)
