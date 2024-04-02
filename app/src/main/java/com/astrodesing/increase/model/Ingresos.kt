package com.astrodesing.increase.model

import com.astrodesing.increase.data.entities.EntitiesIngresos

data class Ingresos(
    var cantidad: Double,
    var categoryId: Int,
    var fecha: String

)
fun Ingresos.toDatabase() =
    EntitiesIngresos(cantidad = cantidad, categoryId = categoryId, fecha = fecha)

data class IngresosPorCategoriaDomain(
    var ingreso: Ingresos,
    var categorias: List<Categorias>
)