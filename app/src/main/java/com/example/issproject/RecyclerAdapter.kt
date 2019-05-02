package com.example.issproject

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.issproject.model.Response

import java.util.ArrayList

class RecyclerAdapter(private var adapterList: ArrayList<Response>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(viewGroup.context)
                .inflate(R.layout.pass_item, viewGroup, false)
        )
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val response = adapterList[i]
        viewHolder.duration.text = response.duration.toString()
        viewHolder.riseTime.text = response.risetime.toString()
    }

    override fun getItemCount(): Int {
        return adapterList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val riseTime: TextView = itemView.findViewById(R.id.riseTimeVal)
        internal val duration: TextView = itemView.findViewById(R.id.durationVal)

    }
}
