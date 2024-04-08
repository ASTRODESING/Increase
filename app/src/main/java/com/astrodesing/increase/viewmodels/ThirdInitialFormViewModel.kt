package com.astrodesing.increase.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.astrodesing.increase.data.entities.EntitiesModalidades
import com.astrodesing.increase.data.entities.IngresosPorCategorias
import com.astrodesing.increase.data.repositories.RepositorieIngresos
import com.astrodesing.increase.data.repositories.repositorieModalidades
import com.astrodesing.increase.model.Ingresos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import javax.inject.Inject

@HiltViewModel
class ThirdInitialFormViewModel @Inject constructor (
    private val repositorieIngresos: RepositorieIngresos,
    private val repositorieModalidades: repositorieModalidades
) : ViewModel() {
    suspend fun addIngreso(ingreso:Ingresos){
        repositorieIngresos.addIngreso(ingreso)
    }
    suspend fun getModalidades():List<EntitiesModalidades>{
        val modalidades:Deferred<List<EntitiesModalidades>> = viewModelScope.async(Dispatchers.IO) {
            return@async repositorieModalidades.getModalidad()
        }
        return modalidades.await()
    }


}