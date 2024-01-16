package com.example.contacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.DM.ContentDM

class MainActivity : AppCompatActivity() {

    lateinit var rcv_contact:RecyclerView
    lateinit var adaptor :AdaptorContacts
    lateinit var btnAddNewContact:ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         rcv_contact=findViewById(R.id.recv_contact)
        adaptor= AdaptorContacts(getModel()as ArrayList<ContentDM>)
        rcv_contact.adapter=adaptor

        btnAddNewContact=findViewById(R.id.btn_add)
        btnAddNewContact.setOnClickListener {
            var intent = Intent(this , addNewContactActivity::class.java)
            startActivity(intent)
        }

    }



    fun getModel(): ArrayList<ContentDM> {

        var itemModel1 = ContentDM("mohamed", "0107040981"," ")

        var itemList: ArrayList<ContentDM> = ArrayList()
        itemList.add(itemModel1)

        return itemList
    }


}