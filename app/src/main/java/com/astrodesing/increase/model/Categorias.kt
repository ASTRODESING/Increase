package com.astrodesing.increase.model

import com.astrodesing.increase.data.entities.EntitiesCategorias


data class Categorias (
    val id:Int?,
    val nombreCategoria: String
)

fun Categorias.toDatabase()= EntitiesCategorias(id = id,nombreCategoria=nombreCategoria)