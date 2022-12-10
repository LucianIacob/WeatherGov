package com.liacob.weathergov.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.liacob.weathergov.R
import com.liacob.weathergov.domain.model.WeatherAlert

class AlertsAdapter : RecyclerView.Adapter<AlertsAdapter.AlertViewHolder>() {

    var items: List<WeatherAlert> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlertViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.alert_layout, parent, false)
        return AlertViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlertViewHolder, position: Int) {
        val alert = items[position]
        holder.event.text = alert.event
    }

    override fun getItemCount() = items.size

    class AlertViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val event: TextView

        init {
            event = itemView.findViewById(R.id.event)
        }
    }
}