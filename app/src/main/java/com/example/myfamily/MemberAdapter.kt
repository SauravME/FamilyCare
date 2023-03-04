package com.example.myfamily

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MemberAdapter(private  val itemMember : List<MemberModel>) : RecyclerView.Adapter<MemberAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val item= inflater.inflate(R.layout.item_member,parent,false)
        return ViewHolder(item)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemMember[position]
        holder.name.text = item.name
        holder.battery.text = item.battery
        holder.follower.text =item.follower
    }
    override fun getItemCount(): Int {
        return itemMember.size
    }


    class ViewHolder(item: View) :RecyclerView.ViewHolder(item){
        val name = item.findViewById<TextView>(R.id.user_name_item_member)!!
        val battery= item.findViewById<TextView>(R.id.battery_text)!!
        val follower = item.findViewById<TextView>(R.id.follower_text)!!
    }

}