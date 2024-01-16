package com.example.contacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.content.ContextCompat.startActivity

class addNewContactActivity : AppCompatActivity() {

    lateinit var btnSave:Button
    lateinit var btnClose:Button

    lateinit var edtName:EditText
    lateinit var edtPhone:EditText
    lateinit var edtAddittionalInformation:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_contact)

        btnSave=findViewById(R.id.imv_save)
        btnClose=findViewById(R.id.imv_close)
        edtName=findViewById(R.id.edt_add_name)
        edtPhone=findViewById(R.id.edt_add_phone)
        edtAddittionalInformation=findViewById(R.id.edt_add_describtion)


        btnSave.setOnClickListener {
           // save()
        }

        btnClose.setOnClickListener {
            var intent= Intent(this , MainActivity::class.java)
            startActivity(intent)
          //  Finish()

        }


    }

//    fun save(){
//        var intent= Intent(this , MainActivity::class.java)
//        intent.putExtra("name", " ")
//        intent.putExtra("phone", " ")
//        intent.putExtra("addittionalInformation", " ")
//        startActivity(intent)
//        // Finsh()
//    }

//    fun validName():Boolean{
//        if (edtName.text.toString().trim().isEmpty()) {
//            return false
//        } else {
//            return true
//        }
//    }
//    fun validPhone():Boolean{
//        if (edtPhone.text.toString().trim().isEmpty()) {
//            return false
//        } else if (edtPhone.text.toString().trim().length > 11) {
//            return true
//        }
//    }
}