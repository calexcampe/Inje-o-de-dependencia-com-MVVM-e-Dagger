package com.admin.exemplo_dagger.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.admin.exemplo_dagger.R
import com.admin.exemplo_dagger.Util
import com.admin.exemplo_dagger.response.SolicitationsResponse
import kotlinx.android.synthetic.main.layout_history_services.view.*


class HistoryServiceAdapter(
    val myData: List<SolicitationsResponse.Data>,
    val context: Context,

): RecyclerView.Adapter<HistoryServiceAdapter.ViewHolder>() {

    val util: Util = Util()
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name = itemView.tv_historyClientName
        val status = itemView.tv_statusHistory
        val service = itemView.tv_typeServiceHistory

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_history_services, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = myData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = myData[position]


        holder.name.text = item.user.fullname
        holder.service.text = item.serviceType
        if (item.date!=null)
        holder.status.text = "Realizado em ${util.formatDate(item.date)}"

    }
}