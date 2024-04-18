package com.astrodesing.increase.ui.dashboard

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.astrodesing.increase.R
import com.astrodesing.increase.databinding.FragmentDashboardWelcomeBinding
import com.astrodesing.increase.viewmodels.dashboardviewmodels.DashboardWelcomeFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

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
        CoroutineScope(Dispatchers.IO).launch {
            val baseData = dashboardWelcomeFragmentViewModel.collectUserName()
            activity?.runOnUiThread(){
                binding.nombreUsuario.text = baseData[0].userName.toString()
                if(binding.nombreUsuario.text.toString() =="andrew"){
                    Log.i()
                }
            }
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