package com.example.exercice3kotlin

private val list= arrayOf("jaafar","ahmad")
object testRegistration {

    fun validation(name:String,password:String,confirmpass:String):Boolean {
        if (name.isEmpty() || password.isEmpty()) {
            return false

        }
        if (password != confirmpass) {
            return false

        }
        if (name in list || !password.isEmpty()) {
            return true
        }
        return true
    }
}