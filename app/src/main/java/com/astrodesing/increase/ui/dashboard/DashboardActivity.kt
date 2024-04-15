package com.astrodesing.increase.ui.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.fragment.app.add
import com.astrodesing.increase.R
import com.astrodesing.increase.databinding.ActivityDashboardBinding
import com.astrodesing.increase.ui.dashboard.DashboardWelcomeFragment.Companion.FRAGMENT_ADDRESS
import com.astrodesing.increase.ui.dashboard.DashboardWelcomeFragment.Companion.FRAGMENT_NAME
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {

    lateinit var binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)

        setContentView(binding.root)


        if (savedInstanceState == null) {
            val bundle =
                bundleOf(FRAGMENT_NAME to "DashboardWelcomeFragment", FRAGMENT_ADDRESS to "Welcome")

            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<DashboardWelcomeFragment>(
                    R.id.fragment_container_dashboard,
                    args = bundle
                ) //El view Binding por alguna razon no funciona, se tiene que utilizar R
            }
        }
        initUi()
    }

    private fun initUi() {

    }
}