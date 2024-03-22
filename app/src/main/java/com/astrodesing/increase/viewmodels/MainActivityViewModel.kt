package com.astrodesing.increase.viewmodels


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.astrodesing.increase.data.repositories.repositorieBase
import com.astrodesing.increase.model.Base
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repositorioBase: repositorieBase) :
    ViewModel() {


    var userName: String = ""
    var userAge: Int = 18


    fun addUser(user: Base) {
        viewModelScope.launch {
            repositorioBase.createUser(user)
        }
    }

    suspend fun isFirstInit(): List<Base> {

        val firstinit: Deferred<List<Base>> = viewModelScope.async(Dispatchers.IO) {
            return@async repositorioBase.readFirtUser()
        }
        return firstinit.await()


    }
}