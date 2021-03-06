package com.example.ep7ld.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.ep7ld.R

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
//        val textView: TextView = root.findViewById(R.id.text_dashboard)
////        dashboardViewModel.text.observe(this, Observer {
////            textView.text = it
////        })

        dashboardViewModel.usuario?.value?.nome = "Outro nome"
        dashboardViewModel.usuario?.observe(viewLifecycleOwner, Observer {
            Toast.makeText(this.context, "O usuário foi alterado", Toast.LENGTH_SHORT).show()
        })
        return root
    }
}