package com.astrodesing.increase.utils

import android.util.Log
import java.util.Calendar

class DateProcessor {

    /* Calcula de distintas el numero de veces que se repite un dia para poder obtener un numero
    * con el cual poder hacer inserts,calcular tiempos estimados,etc... */
    /* Calcula el numero del dia de las quincenas del mes y el ultimo deia del mes*/
    fun dateProcessorByMode(modo: String, listaDeDias: List<String>, mes: Int, year: Int): Int {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, mes - 1)
        Log.i("Mes", Calendar.MONTH.toString())
        val lastDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

        when (modo) {
            "Quincenal" -> {
                val quincena = lastDayOfMonth / 2
                return quincena
            }

            "Mensual" -> {
                return lastDayOfMonth
            }

            "Diario" -> {

            }
        }
        return 0
    }
}