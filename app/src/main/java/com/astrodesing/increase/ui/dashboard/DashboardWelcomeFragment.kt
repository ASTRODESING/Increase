package com.astrodesing.increase.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.astrodesing.increase.R
import com.astrodesing.increase.databinding.FragmentDashboardWelcomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardWelcomeFragment : Fragment() {
    private var name: String? = null
    private var address: String? = null
    private lateinit var binding:FragmentDashboardWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(FRAGMENT_NAME)
            address = it.getString(FRAGMENT_ADDRESS)
        }

        binding= FragmentDashboardWelcomeBinding.inflate(layoutInflater)



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