package com.astrodesing.increase.viewmodels

import com.astrodesing.increase.data.entities.EntitiesBase
import com.astrodesing.increase.data.repositories.repositorieBase
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repositorioBase: repositorieBase) {

    var userName:String =""
    var userAge:Int=18

    suspend fun addUser(){
        repositorioBase.createUser(EntitiesBase(userName = userName, userAge = userAge, userFirstInit = true))
    }
}