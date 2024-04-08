package com.astrodesing.increase.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.astrodesing.increase.data.entities.EntitiesModalidades
import com.astrodesing.increase.data.repositories.RepositorieIngresos
import com.astrodesing.increase.data.repositories.repositorieBase
import com.astrodesing.increase.data.repositories.repositorieModalidades
import com.astrodesing.increase.model.Base
import com.astrodesing.increase.model.Categorias
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SecondInitialFormViewModel @Inject constructor(
    private val repositorioBase: repositorieBase,
    private val repositorieIngresos: RepositorieIngresos,
    private val repositorieModalidades: repositorieModalidades
) : ViewModel() {
    suspend fun addUser(user: Base) {
        viewModelScope.launch {
            repositorioBase.createUser(user)
        }
    }
    suspend fun addCategoria(categoria: Categorias){
        repositorieIngresos.addCategoria(categoria)
    }

    suspend fun addModalidad(modalidad: EntitiesModalidades) {
        repositorieModalidades.addModalidad(modalidad)
    }

}