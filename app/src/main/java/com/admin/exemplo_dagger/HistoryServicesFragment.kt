package com.admin.exemplo_dagger


import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.admin.exemplo_dagger.adapter.HistoryServiceAdapter

import kotlinx.android.synthetic.main.fragment_history_services.view.*

class HistoryServicesFragment : BaseFragment<HistoryPayServicesViewModel>() {

    override val layoutRes = R.layout.fragment_history_services
    override fun getViewModel() = HistoryPayServicesViewModel::class.java
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getSolicitations(sharedPref.getInt("idUser",0),"Serviço realizado")
        viewModel.solicitations.observe(viewLifecycleOwner, Observer {
            view.rv_historyService.adapter = HistoryServiceAdapter(it.data, requireContext())
            view.rv_historyService.layoutManager = LinearLayoutManager(requireContext())
        })
    }


}
