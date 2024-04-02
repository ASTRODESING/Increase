package com.astrodesing.increase.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.astrodesing.increase.data.repositories.repositorieBase
import com.astrodesing.increase.model.Base
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SecondInitialFormViewModel @Inject constructor(private val repositorioBase: repositorieBase):ViewModel() {
    suspend fun addUser(user: Base) {
        viewModelScope.launch {
            repositorioBase.createUser(user)
        }
    }

}