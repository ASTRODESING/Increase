package com.astrodesing.increase.data.repositories

import com.astrodesing.increase.data.daos.DaoModalidades
import com.astrodesing.increase.data.entities.EntitiesModalidades
import javax.inject.Inject

class repositorieModalidades @Inject constructor(private val dao:DaoModalidades) {
    suspend fun addModalidad(modalidad:EntitiesModalidades){
        dao.addModalidad(modalidad)
    }
    fun getModalidad():List<EntitiesModalidades>{
        return dao.readModalidades()
    }
}