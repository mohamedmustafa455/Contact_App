package com.example.contacts.DM

data class ContentDM(var name:String , var phone:String , var descripe:String){

    constructor(name: String , phone :String) : this(name ,phone,"  ")

}
