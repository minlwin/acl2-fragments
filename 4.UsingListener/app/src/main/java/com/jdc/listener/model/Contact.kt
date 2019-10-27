package com.jdc.listener.model

data class Contact(
    var group:String,
    var name:String,
    var phone:String,
    var email:String,
    var address:String
) {
    val header:String
        get() = group.substring(0, 1).toUpperCase()
}