package com.astrodesing.increase.data.repositories

import com.astrodesing.increase.data.daos.DaoIngresos
import com.astrodesing.increase.data.entities.IngresosPorCategorias
import com.astrodesing.increase.data.entities.toDomain
import com.astrodesing.increase.model.Categorias
import com.astrodesing.increase.model.Ingresos
import com.astrodesing.increase.model.toDatabase
import javax.inject.Inject

class RepositorieIngresos @Inject constructor(private val dao: DaoIngresos) {
    suspend fun addIngreso(ingresos: Ingresos) {
        dao.addIngreso(ingresos.toDatabase())
    }
    suspend fun addCategoria(categorias: Categorias){
        dao.addCategoria(categorias.toDatabase())
    }
    suspend fun getAllIngresos():List<Ingresos>{
        val ingresosdata = dao.readIngresosData()
        return ingresosdata.map { it.toDomain() }
    }
    suspend fun getAllCategorias():List<Categorias>{
        val categoriasData = dao.readCategoryData()
        return categoriasData.map { it.toDomain() }
    }
    suspend fun getIngresosPorCategorias():List<IngresosPorCategorias>{
        val ingresosPorCategorias = dao.getIngresosPorCategorias()
        return ingresosPorCategorias
    }


}