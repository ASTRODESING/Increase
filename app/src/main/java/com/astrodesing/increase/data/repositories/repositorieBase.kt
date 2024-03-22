package com.astrodesing.increase.data.repositories

import android.util.Log
import androidx.lifecycle.asFlow
import androidx.lifecycle.map
import com.astrodesing.increase.data.daos.DaoBase
import com.astrodesing.increase.data.entities.EntitiesBase
import com.astrodesing.increase.model.Base
import com.astrodesing.increase.model.toDatabase
import com.astrodesing.increase.model.toDomain
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject



class repositorieBase @Inject constructor(private val daos:DaoBase) {

    suspend fun readFirtUser(): List<Base> {
        val firstInit = daos.readFirstUserData()
        return firstInit.map { it.toDomain() }
    }
    suspend fun createUser(user:Base){
        daos.addUser(user.toDatabase())
    }
}