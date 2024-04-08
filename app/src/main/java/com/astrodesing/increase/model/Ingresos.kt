package com.astrodesing.increase.model

import com.astrodesing.increase.data.entities.EntitiesIngresos

data class Ingresos(
    var cantidad: Double,
    var categoryId: Int,
    var description:String,
    var fecha: String,
    var modalidad:String

)
fun Ingresos.toDatabase() =
    EntitiesIngresos(
        id = null,
        cantidad = cantidad,
        categoryId = categoryId,
        description = description,
        fecha = fecha,
        modalidad = modalidad)

data class IngresosPorCategoriaDomain(
    var ingreso: Ingresos,
    var categorias: List<Categorias>
)