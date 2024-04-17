/*package com.astrodesing.increase.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.astrodesing.increase.data.repositories.RepositorieIngresos
import com.astrodesing.increase.data.repositories.repositorieBase
import com.astrodesing.increase.model.Base
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repositorieBase: repositorieBase,
    repositorieIngresos: RepositorieIngresos
):ViewModel() {

    suspend fun collectName():List<Base>{
        val user = repositorieBase.readFirtUser()
        return user

    }
}*/