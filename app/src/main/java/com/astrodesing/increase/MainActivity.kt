package com.astrodesing.increase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.astrodesing.increase.databinding.ActivityMainBinding
import com.astrodesing.increase.viewmodels.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val mainActivityViewModel :MainActivityViewModel by viewModels<MainActivityViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initUi()
    }

    private fun initUi() {
        mainActivityViewModel.isFirstInit()
        var isFirstInit = mainActivityViewModel.firstUser
        binding.user.text = isFirstInit.collect{isFirstInit ->  }


    }
}