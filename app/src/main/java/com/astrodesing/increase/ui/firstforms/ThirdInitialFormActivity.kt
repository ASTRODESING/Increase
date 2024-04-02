package com.astrodesing.increase.ui.firstforms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import com.astrodesing.increase.databinding.ActivityThirdInitialFormBinding
import com.astrodesing.increase.model.Categorias
import com.astrodesing.increase.model.Ingresos
import com.astrodesing.increase.viewmodels.SecondInitialFormViewModel
import com.astrodesing.increase.viewmodels.ThirdInitialFormViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@AndroidEntryPoint
class ThirdInitialFormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdInitialFormBinding
    private val thirdInitialFormViewModel: ThirdInitialFormViewModel by viewModels<ThirdInitialFormViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityThirdInitialFormBinding.inflate(layoutInflater)

        setContentView(binding.root)


        initUi()
    }

    private fun initUi() {
        initLists()
        recollectData()

    }

    private fun recollectData() {
        binding.btnNextform02.setOnClickListener() {
            if (binding.ingresoMensual.text.toString()
                    .isNotEmpty() && binding.gastoMensual.text.toString()
                    .isNotEmpty() && binding.actvGastosMode.text.isNotEmpty() &&
                binding.actvIngresosMode.text.toString().isNotEmpty()
            ) {
                CoroutineScope(Dispatchers.IO).launch {
                    thirdInitialFormViewModel.addCategoria(Categorias(nombreCategoria = "Salario"))
                    thirdInitialFormViewModel.addIngreso(
                        Ingresos(
                            cantidad = binding.ingresoMensual.text.toString().toDouble(),
                            categoryId =0,
                            fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyy")))
                    )

                }

            } else {
                val toast =
                    Toast.makeText(this, "Aun existen campos sin rellenar", Toast.LENGTH_LONG)
                toast.show()
            }

        }
    }


    private fun initLists() {
        val spinnerItems = listOf("Quincenal", "Mensual", "Pagos Irregulares")
        val adapterSpinner =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item)
        adapterSpinner.addAll(spinnerItems)
        binding.actvIngresosMode.setAdapter(adapterSpinner)
        binding.actvGastosMode.setAdapter(adapterSpinner)
    }
}