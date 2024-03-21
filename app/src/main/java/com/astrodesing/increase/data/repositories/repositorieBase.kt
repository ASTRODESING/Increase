package com.astrodesing.increase.data.repositories

import com.astrodesing.increase.data.daos.DaoBase
import com.astrodesing.increase.data.entities.EntitiesBase
import javax.inject.Inject


class repositorieBase @Inject constructor(private val daos:DaoBase) {

    suspend fun readFirtUser(){
        daos.readFirstUserData()
    }
    suspend fun createUser(user: EntitiesBase){
        daos.addUser(user)
    }
}