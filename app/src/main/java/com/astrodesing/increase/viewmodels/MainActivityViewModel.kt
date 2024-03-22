package com.astrodesing.increase.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.astrodesing.increase.data.entities.EntitiesBase
import com.astrodesing.increase.data.repositories.repositorieBase
import com.astrodesing.increase.model.Base
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repositorioBase: repositorieBase):ViewModel() {



    var userName:String =""
    var userAge:Int=18
    lateinit var firstUser: Flow<List<EntitiesBase>>

   fun addUser(user : Base){
        viewModelScope.launch {
            repositorioBase.createUser(user)
        }
    }
    fun isFirstInit(){
         viewModelScope.launch {
             var firstUser = repositorioBase.readFirtUser()
        }
    }
}