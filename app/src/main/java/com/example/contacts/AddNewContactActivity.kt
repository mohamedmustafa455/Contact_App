package com.example.contacts

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast


class AddNewContactActivity : AppCompatActivity() {

    private lateinit var  btnSave:ImageView
    private lateinit var btnClose:ImageView

    private lateinit var edtName:EditText
    private lateinit var edtPhone:EditText
    private lateinit var edtAddittionalInformation:EditText

    private lateinit var name:String
    private lateinit var phone :String
    private lateinit var description:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_contact)

        btnSave=findViewById(R.id.imv_save)
        btnClose=findViewById(R.id.imv_close)
        edtName=findViewById(R.id.edt_add_name)
        edtPhone=findViewById(R.id.edt_add_phone)
        edtAddittionalInformation=findViewById(R.id.edt_add_describtion)

        btnSave.setOnClickListener {
            if( dataIsValid()){
                save()
            }
        }

        btnClose.setOnClickListener {
            val intent= Intent(this , MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
    private fun save(){
        val intent= Intent(this , MainActivity::class.java)
        intent.putExtra("name", name)
        intent.putExtra("phone", phone)
        intent.putExtra("addittionalInformation", description)
        setResult(RESULT_OK,intent)
        finish()

// RESULT_OK is a predefined constant that indicates a successful result
//        setResult(Activity.RESULT_OK, intent)
//        finish()
    }

    private fun dataIsValid():Boolean {
        if(nameIsValid()&&phoneIsvalid())
            return true

        return false
    }

    private fun nameIsValid():Boolean{
        readDataFromEditText()
        if (edtName.text.toString().trim().isNotEmpty())
            return true
        Toast.makeText(this, "name is not valid ", Toast.LENGTH_SHORT).show()
        return false
    }

    //To validate phone and i will add regex validate number
    private fun phoneIsvalid():Boolean{
        readDataFromEditText()
        if (isValidPhoneNumber(phone)){//phone.length == 11
            return true
        }

        Toast.makeText(this, "phone is not valid must be 11 number ", Toast.LENGTH_SHORT).show()
        return false
    }

//This regex matches phone numbers that start with 01 followed by either 0, 1, 2, or 5, and then 8 digits. =>
//    "^01 [0-2,5]\\d{8}$"
    fun isValidPhoneNumber(phoneNumber: String): Boolean {
        val regex = Regex("^\\+(?:[0-9] ?){6,14}[0-9]$") // International phone number regex
        return regex.matches("+02"+phoneNumber)
    }

    //To read the data every time we will validation data instead of live data
    private fun readDataFromEditText(){
        name= edtName.text.toString()
        phone = edtPhone.text.toString()
        description=edtAddittionalInformation.text.toString()
    }
}