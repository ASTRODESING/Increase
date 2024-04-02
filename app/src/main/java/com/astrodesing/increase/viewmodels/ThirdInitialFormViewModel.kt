package com.astrodesing.increase.viewmodels

import androidx.lifecycle.ViewModel
import com.astrodesing.increase.data.repositories.RepositorieIngresos
import com.astrodesing.increase.model.Categorias
import com.astrodesing.increase.model.Ingresos
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ThirdInitialFormViewModel @Inject constructor (
    private val repositorieIngresos: RepositorieIngresos,
    /*private val repositorieGastos: RepositorieGastos*/
) : ViewModel() {
    suspend fun addIngreso(ingreso:Ingresos){
        repositorieIngresos.addIngreso(ingreso)
    }
    suspend fun addCategoria(categoria:Categorias){
        repositorieIngresos.addCategoria(categoria)
    }
}