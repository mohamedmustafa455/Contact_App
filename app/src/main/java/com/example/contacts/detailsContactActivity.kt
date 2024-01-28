package com.example.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class detailsContactActivity : AppCompatActivity() {

    lateinit var tvName:TextView
    lateinit var tvphone:TextView
    lateinit var tvDetails:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_contact)

        tvName=findViewById(R.id.tv_name_details)
        tvphone=findViewById(R.id.tv_phone_details)
        tvDetails=findViewById(R.id.tv_description_details)

        intent.getStringExtra("name").let {
            tvName.text=it.toString()
        }

        var phone =intent.getStringExtra("phone").let {
            tvphone.text = it.toString()
        }
        intent.getStringExtra("description").let {
            tvDetails.text=it.toString()
        }



    }
}