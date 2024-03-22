package com.astrodesing.increase.data.repositories

import androidx.lifecycle.asFlow
import com.astrodesing.increase.data.daos.DaoBase
import com.astrodesing.increase.data.entities.EntitiesBase
import com.astrodesing.increase.model.Base
import com.astrodesing.increase.model.toDatabase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject



class repositorieBase @Inject constructor(private val daos:DaoBase) {

    suspend fun readFirtUser(): Flow<List<EntitiesBase>> {
        val firstInit = daos.readFirstUserData()
        return firstInit.asFlow()
    }
    suspend fun createUser(user:Base){
        daos.addUser(user.toDatabase())
    }
}