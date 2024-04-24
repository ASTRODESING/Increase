package com.astrodesing.increase.ui.firstforms

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.astrodesing.increase.databinding.ActivityThirdInitialFormBinding
import com.astrodesing.increase.model.Ingresos
import com.astrodesing.increase.ui.dashboard.DashboardActivity
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
                var diasDeLaSemanaGasto = ""
                var diasDeLaSemanaIngreso = ""

//
//                if (binding.checkBoxIngreso1.isChecked) {
//                    diasDeLaSemanaIngreso += "LUN"
//                }
//                if (binding.checkBoxIngreso2.isChecked) {
//                    diasDeLaSemanaIngreso += "MAR"
//                }
//                if (binding.checkBoxIngreso3.isChecked) {
//                    diasDeLaSemanaIngreso += "MIE"
//                }
//                if (binding.checkBoxIngreso4.isChecked) {
//                    diasDeLaSemanaIngreso += "JUE"
//                }
//                if (binding.checkBoxIngreso5.isChecked) {
//                    diasDeLaSemanaIngreso += "VIE"
//                }
//                if (binding.checkBoxIngreso6.isChecked) {
//                    diasDeLaSemanaIngreso += "SAB"
//                }
//                if (binding.checkBoxIngreso7.isChecked) {
//                    diasDeLaSemanaIngreso += "DOM"
//                }
//
//                if (binding.checkBoxGasto1.isChecked) {
//                    diasDeLaSemanaGasto += "LUN"
//                }
//                if (binding.checkBoxGasto2.isChecked) {
//                    diasDeLaSemanaGasto += "MAR"
//                }
//                if (binding.checkBoxGasto3.isChecked) {
//                    diasDeLaSemanaGasto += "MIE"
//                }
//                if (binding.checkBoxGasto4.isChecked) {
//                    diasDeLaSemanaGasto += "JUE"
//                }
//                if (binding.checkBoxGasto5.isChecked) {
//                    diasDeLaSemanaGasto += "VIE"
//                }
//                if (binding.checkBoxGasto6.isChecked) {
//                    diasDeLaSemanaGasto += "SAB"
//                }
//                if (binding.checkBoxGasto7.isChecked) {
//                    diasDeLaSemanaGasto += "DOM"
//                }


                CoroutineScope(Dispatchers.IO).launch {
                    thirdInitialFormViewModel.addIngreso(
                        Ingresos(
                            cantidad = binding.ingresoMensual.text.toString().toDouble(),
                            categoryId = 0,
                            description = "Primer Ingreso",
                            fecha = LocalDateTime.now()
                                .format(DateTimeFormatter.ofPattern("dd/MM/yyy")),
                            modalidad = binding.actvIngresosMode.text.toString(),
                            diasDeLaSemana = ""
                        )
                    )
                    runOnUiThread() {
                        val intent =
                            Intent(this@ThirdInitialFormActivity, DashboardActivity::class.java)
                        startActivity(intent)
                    }

                }

            } else {
                val toast =
                    Toast.makeText(this, "Aun existen campos sin rellenar", Toast.LENGTH_LONG)
                toast.show()
            }

        }
    }


    private fun initLists() {
        CoroutineScope(Dispatchers.IO).launch {
            val modalidades = thirdInitialFormViewModel.getModalidades()
            runOnUiThread() {
                val spinnerItems: MutableList<String> = mutableListOf()
                for (modalidad in modalidades) {
                    spinnerItems.add(modalidad.modalidad)
                }
                val adapterSpinner =
                    ArrayAdapter<String>(
                        this@ThirdInitialFormActivity,
                        android.R.layout.simple_spinner_dropdown_item
                    )
                adapterSpinner.addAll(spinnerItems)

                binding.actvIngresosMode.setAdapter(adapterSpinner)
                binding.actvGastosMode.setAdapter(adapterSpinner)

                binding.actvIngresosMode.setOnItemClickListener { _, _, _, _ ->
                    if (binding.actvIngresosMode.text.toString() == "Diario") {
                        binding.checkBoxLayOutIngreso.visibility = View.VISIBLE
                    } else {
                        binding.checkBoxLayOutIngreso.visibility = View.INVISIBLE
                    }
                }

                binding.actvGastosMode.setOnItemClickListener { _, _, _, _ ->
                    if (binding.actvGastosMode.text.toString() == "Diario") {
                        binding.checkBoxLayOutGasto.visibility = View.VISIBLE
                    } else {
                        binding.checkBoxLayOutGasto.visibility = View.INVISIBLE
                    }
                }
            }
        }


    }


}