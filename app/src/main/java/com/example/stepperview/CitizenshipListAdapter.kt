package com.example.stepperview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CitizenshipListAdapter(
    private val listCountry: ArrayList<Country>,
    private val onClickListener: (Country) -> Unit
) :
    RecyclerView.Adapter<CitizenshipListAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvCountryName: TextView = itemView.findViewById(R.id.tv_item_country)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val country: Country = listCountry[position]
        holder.tvCountryName.text = country.name?.uppercase()
        holder.tvCountryName.setOnClickListener {
            onClickListener(country)
        }
    }

    override fun getItemCount(): Int = listCountry.size
}