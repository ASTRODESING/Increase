package com.astrodesing.increase.ui.dashboard

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.astrodesing.increase.R
import com.astrodesing.increase.databinding.FragmentDashboardWelcomeBinding
import com.astrodesing.increase.viewmodels.dashboardviewmodels.DashboardWelcomeFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DashboardWelcomeFragment : Fragment() {
    private var name: String? = null
    private var address: String? = null
    private lateinit var binding: FragmentDashboardWelcomeBinding
    private val dashboardWelcomeFragmentViewModel: DashboardWelcomeFragmentViewModel by activityViewModels<DashboardWelcomeFragmentViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(FRAGMENT_NAME)
            address = it.getString(FRAGMENT_ADDRESS)
        }
        binding = FragmentDashboardWelcomeBinding.inflate(layoutInflater)
        collectData()

    }

    private fun collectData() {
        lifecycleScope.launch(Dispatchers.IO) {
            val baseData = dashboardWelcomeFragmentViewModel.collectUserName()
            var ingresosEsteMes =
                dashboardWelcomeFragmentViewModel.collectIngresosTotalesMensuales()
            activity?.runOnUiThread(Runnable {
                val nombreUsuario = view?.findViewById<TextView>(R.id.nombre_usuario)
                val ingresosTotalesMensual =
                    view?.findViewById<TextView>(R.id.ingresosTotalesMensuales)

                nombreUsuario?.text = baseData[0].userName
                ingresosTotalesMensual?.text = ingresosEsteMes.toString()

            })
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard_welcome, container, false)
    }

    companion object {

        const val FRAGMENT_NAME = "name_bundle"
        const val FRAGMENT_ADDRESS = "address_bundle"

        @JvmStatic
        fun newInstance(name: String, address: String) =
            DashboardWelcomeFragment().apply {
                arguments = Bundle().apply {
                    putString(FRAGMENT_NAME, name)
                    putString(FRAGMENT_ADDRESS, address)
                }
            }
    }
}