package com.astrodesing.increase.ui.firstforms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.astrodesing.increase.R
import com.astrodesing.increase.databinding.ActivityFirstInitialFormBinding

class FirstInitialFormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstInitialFormBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFirstInitialFormBinding.inflate(layoutInflater)

        setContentView(binding.root)
        redirectSecondForm()
    }

    private fun redirectSecondForm() {
        binding.btnNextform01.setOnClickListener(){
            val intent = Intent(this,SecondInitialFormActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}