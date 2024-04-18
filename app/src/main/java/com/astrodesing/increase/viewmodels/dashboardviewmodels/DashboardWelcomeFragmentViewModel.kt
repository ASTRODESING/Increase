package com.astrodesing.increase.viewmodels.dashboardviewmodels

import androidx.lifecycle.ViewModel
import com.astrodesing.increase.data.repositories.RepositorieIngresos
import com.astrodesing.increase.data.repositories.repositorieBase
import com.astrodesing.increase.model.Base
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardWelcomeFragmentViewModel @Inject constructor(
    private val repositorieBase: repositorieBase,
    private val repositorieIngresos: RepositorieIngresos
) : ViewModel() {
    suspend fun collectUserName():List<Base>{
       val user = repositorieBase.readFirtUser()
        return user
    }
}