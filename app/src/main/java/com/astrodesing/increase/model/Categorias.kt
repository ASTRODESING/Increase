package com.astrodesing.increase.model

import com.astrodesing.increase.data.entities.EntitiesCategorias


data class Categorias (
    val nombreCategoria: String
)

fun Categorias.toDatabase()= EntitiesCategorias(nombreCategoria=nombreCategoria)