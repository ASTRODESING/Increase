package com.astrodesing.increase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.astrodesing.increase.databinding.ActivityMainBinding
import com.astrodesing.increase.model.Base
import com.astrodesing.increase.viewmodels.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val mainActivityViewModel :MainActivityViewModel by viewModels<MainActivityViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        initDb()
        initUi()

    }

    private fun initDb() {
        var user = Base(userName = "Hols", userAge = 18,userFirstInit = true)
        mainActivityViewModel.addUser(user)
    }

    private fun initUi() {
        CoroutineScope(Dispatchers.IO).launch {
            var isFirstInit = mainActivityViewModel.isFirstInit()
            Log.i("Ultimate Test", "${isFirstInit[0].userFirstInit}")
        }


    }
}