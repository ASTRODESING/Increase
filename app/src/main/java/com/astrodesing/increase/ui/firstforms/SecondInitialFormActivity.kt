package com.astrodesing.increase.ui.firstforms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.astrodesing.increase.data.entities.EntitiesModalidades
import com.astrodesing.increase.databinding.ActivitySecondInitialFormBinding
import com.astrodesing.increase.model.Base
import com.astrodesing.increase.model.Categorias
import com.astrodesing.increase.viewmodels.SecondInitialFormViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SecondInitialFormActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondInitialFormBinding
    private val secondInitialFormViewModel: SecondInitialFormViewModel by viewModels<SecondInitialFormViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondInitialFormBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initUi()
    }

    private fun initUi() {
        binding.btnNextform02.setOnClickListener() {
            initializeDatabase()
            addUser()
        }
    }

    private fun initializeDatabase() {
        CoroutineScope(Dispatchers.IO).launch{
            secondInitialFormViewModel.addModalidad(EntitiesModalidades(modalidad = "Quincenal"))
            secondInitialFormViewModel.addModalidad(EntitiesModalidades(modalidad = "Mensual"))
            secondInitialFormViewModel.addModalidad(EntitiesModalidades(modalidad = "Semanal"))
            secondInitialFormViewModel.addModalidad(EntitiesModalidades(modalidad = "Pagos Irregulares"))
            secondInitialFormViewModel.addCategoria(Categorias(nombreCategoria = "Salario"))
        }
    }

    private fun redirectToThirdForm() {
        val intent= Intent(this,ThirdInitialFormActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun addUser() {
        if (binding.tietUserName.text.toString().isNotEmpty() && binding.tietUserAge.text.toString()
                .isNotEmpty()
        ) {
            CoroutineScope(Dispatchers.IO).launch {
                secondInitialFormViewModel.addUser(
                    Base(
                        userName = binding.tietUserName.text.toString(),
                        userAge = binding.tietUserAge.text.toString().toInt()
                    )
                )
            }
            redirectToThirdForm()
        } else {
            val toast = Toast.makeText(this, "Aun existen campos sin rellenar", Toast.LENGTH_LONG)
            toast.show()
        }

    }


}