package com.astrodesing.increase


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.astrodesing.increase.databinding.ActivityMainBinding
import com.astrodesing.increase.model.Base
import com.astrodesing.increase.ui.dashboard.DashboardActivity
import com.astrodesing.increase.ui.firstforms.FirstInitialFormActivity
import com.astrodesing.increase.viewmodels.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.log

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainActivityViewModel: MainActivityViewModel by viewModels<MainActivityViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initUi()

    }

    private fun initUi() {
        lateinit var isFirstInit: List<Base>

        CoroutineScope(Dispatchers.IO).launch {
            isFirstInit = mainActivityViewModel.isFirstInit()

            runOnUiThread {
                if (isFirstInit.isNotEmpty()) {

                    /* SI LA VARIABLE isFirstInit CONTIENE ALGUN DATO SIGNIFICA QUE YA HAN INICIADO
                    * LA APP ANTES, PERO SI NO TIENE NINGUN DATO SIGNIFICA QUE ES PRIMERA VEZ QUE
                    * SE INICIA*/
                    val intent = Intent(this@MainActivity, DashboardActivity::class.java)
                    startActivity(intent)

                } else {
                    val intent = Intent(this@MainActivity, FirstInitialFormActivity::class.java)
                    startActivity(intent)


                }
            }


        }
    }
}