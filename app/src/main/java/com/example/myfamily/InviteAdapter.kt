package com.example.myfamily

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class InviteAdapter(private val listContact: List<ContactModel>):
    RecyclerView.Adapter<InviteAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val item = inflater.inflate(R.layout.item_invite,parent,false)
        return ViewHolder(item)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listContact[position]
        holder.inviteName.text = item.name

    }
    override fun getItemCount(): Int {
        return listContact.size
    }

    class ViewHolder(private val item : View):RecyclerView.ViewHolder(item) {
        val inviteName = item.findViewById<TextView>(R.id.text_name)!!
    }

}


