package com.astrodesing.increase.viewmodels


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.astrodesing.increase.data.entities.IngresosPorCategorias
import com.astrodesing.increase.data.repositories.RepositorieIngresos
import com.astrodesing.increase.data.repositories.repositorieBase
import com.astrodesing.increase.model.Base
import com.astrodesing.increase.model.Categorias
import com.astrodesing.increase.model.Ingresos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repositorioBase: repositorieBase,
    private val repositorieIngresos: RepositorieIngresos,
) :
    ViewModel() {


    suspend fun isFirstInit(): List<Base> {

        val firstinit: Deferred<List<Base>> = viewModelScope.async(Dispatchers.IO) {
            return@async repositorioBase.readFirtUser()
        }
        return firstinit.await()
    }

    suspend fun getIngresoPorCategory(): List<IngresosPorCategorias> {
        val ingresos: Deferred<List<IngresosPorCategorias>> = viewModelScope.async(Dispatchers.IO) {
            return@async repositorieIngresos.getIngresosPorCategorias()
        }
        return ingresos.await()
    }

    suspend fun addIngreso(ingreso: Ingresos){
        repositorieIngresos.addIngreso(ingreso)
    }

    suspend fun addCategoria(categoria: Categorias){
        repositorieIngresos.addCategoria(categoria)
    }

}