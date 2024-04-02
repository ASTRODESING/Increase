package com.astrodesing.increase.ui.firstforms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.astrodesing.increase.R
import com.astrodesing.increase.databinding.ActivitySecondInitialFormBinding
import com.astrodesing.increase.databinding.ActivityThirdInitialFormBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ThirdInitialFormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdInitialFormBinding
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
            ){

            }else{
                val toast = Toast.makeText(this, "Aun existen campos sin rellenar", Toast.LENGTH_LONG)
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