package com.example.contacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.DM.ContentDM


class AdaptorContacts(var mydata:ArrayList<ContentDM>):RecyclerView.Adapter<AdaptorContacts.ViewHolderContact>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderContact {
       var view =LayoutInflater.from(parent.context).inflate(R.layout.item_contact,parent,false)
        return ViewHolderContact(view)
    }

    override fun onBindViewHolder(holder: ViewHolderContact, position: Int) {
        holder.tvName.setText(mydata[position].name)
        holder.tvPone.setText(mydata[position].phone)
        holder.tvDescribe.setText(mydata[position].descripe)

    }

    override fun getItemCount(): Int {
        return mydata.size
    }


    class ViewHolderContact (val itemView: View):RecyclerView.ViewHolder(itemView){
        lateinit var tvName:TextView
        lateinit var tvPone:TextView
        lateinit var tvDescribe:TextView
        init {
            tvName=itemView.findViewById(R.id.tv_name) as TextView
            tvPone=itemView.findViewById(R.id.tv_phone)as TextView
            tvDescribe=itemView.findViewById(R.id.tv_descripe)
        }

    }
}