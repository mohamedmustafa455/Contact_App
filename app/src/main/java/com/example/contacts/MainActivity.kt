package com.example.contacts

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.DM.ContentDM
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    lateinit var rcv_contact:RecyclerView
    lateinit var adaptor :AdaptorContacts
    lateinit var btnAddNewContact:ImageButton
    var itemList: ArrayList<ContentDM> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setAdaptor ()
        getModel()
        navigatToAddNewcontact()
        navigatToContactDetails()

    }

    fun setAdaptor (){
        rcv_contact=findViewById(R.id.recv_contact)
        adaptor= AdaptorContacts(itemList )
        rcv_contact.adapter=adaptor
    }
    fun getModel() {
       var name= intent.getStringExtra("name").toString()
       var phone = intent.getStringExtra("phone").toString()
       var description=intent.getStringExtra("addittionalInformation").toString()

        itemList.add(ContentDM(name, phone,description))
        Log.e("MainActivity/getModel1", "itemList: $itemList")

    }
    fun navigatToAddNewcontact(){
        btnAddNewContact=findViewById(R.id.btn_add)
        btnAddNewContact.setOnClickListener {
            var intent = Intent(this , AddNewContactActivity::class.java)
            startActivity(intent)
            // REQUEST_CODE is a constant integer that you define
           // startActivityForResult(intent, REQUEST_CODE)

        }
    }

    fun navigatToContactDetails(){
                adaptor.listner=object :AdaptorContacts.onClikItem{
            override fun onClick(contact: ContentDM) {
                val intent=Intent(applicationContext,detailsContactActivity::class.java)
                //send data
                intent.putExtra("name",contact.name)
                intent.putExtra("phone",contact.phone)
                intent.putExtra("description",contact.descripe)
                startActivity(intent)
            }
        }

    }



}