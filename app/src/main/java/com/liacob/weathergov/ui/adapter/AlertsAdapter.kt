package com.liacob.weathergov.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.liacob.weathergov.R
import com.liacob.weathergov.domain.model.WeatherAlert
import com.liacob.weathergov.ui.utils.asDisplayable
import com.squareup.picasso.Picasso
import java.util.*

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
        with(holder.itemView.context) {
            holder.event.text = getString(R.string.event, alert.event)
            holder.sender.text = getString(R.string.sender, alert.senderName)
            holder.effective.text = getString(R.string.effective, alert.effective.asDisplayable())
            alert.ends?.let {
                holder.end.isVisible = true
                holder.end.text = getString(R.string.ends, alert.ends.asDisplayable())
            } ?: kotlin.run { holder.end.isVisible = false }
            alert.duration?.let {
                holder.duration.isVisible = true
                holder.duration.text = getString(R.string.duration, alert.duration.asDisplayable())
            } ?: kotlin.run { holder.duration.isVisible = false }
        }

        Picasso
            .get()
            .load(RANDOM_IMAGE_URL)
            .stableKey(position.toString())
            .placeholder(R.drawable.placeholder_300)
            .resize(100, 150)
            .into(holder.image)
    }

    override fun getItemCount() = items.size

    companion object {
        private const val RANDOM_IMAGE_URL = "https://picsum.photos/150"
    }

    class AlertViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView
        val event: TextView
        val sender: TextView
        val effective: TextView
        val end: TextView
        val duration: TextView

        init {
            image = itemView.findViewById(R.id.image)
            event = itemView.findViewById(R.id.event)
            sender = itemView.findViewById(R.id.senderName)
            effective = itemView.findViewById(R.id.effective)
            end = itemView.findViewById(R.id.end)
            duration = itemView.findViewById(R.id.duration)
        }
    }
}