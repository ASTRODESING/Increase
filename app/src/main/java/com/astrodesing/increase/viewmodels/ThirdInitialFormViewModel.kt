package com.astrodesing.increase.viewmodels

import androidx.lifecycle.ViewModel
import com.astrodesing.increase.data.repositories.RepositorieIngresos
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ThirdInitialFormViewModel @Inject constructor (
    private val repositorieIngresos: RepositorieIngresos,
    /*private val repositorieGastos: RepositorieGastos*/
) : ViewModel() {
    suspend fun addIngreso(){
        repositorieIngresos.addIngreso()
    }
    suspend fun addCategoria(){
        repositorieIngresos.addCategoria()
    }
}