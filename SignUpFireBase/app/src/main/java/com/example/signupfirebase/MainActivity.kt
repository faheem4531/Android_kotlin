package com.example.signupfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var requestBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestBtn = findViewById(R.id.signup_btn)

        requestBtn.setOnClickListener(){
            post_signup_data_to_firebase()
        }
    }

//    signup button
    private fun post_signup_data_to_firebase(){

//    decleration
    var name = findViewById<EditText> (R.id.name_id)
    var email = findViewById<EditText> (R.id.email_id)
    var password = findViewById<EditText> (R.id.password_id)

//    convert to string
    var name_ = name.text.toString()
    var email_ = email.text.toString()
    var password_ = password.text.toString()


//    Validation
    if(name_.isEmpty())
    {
        name.setError("enter your name")
        name.requestFocus()
        return
    }
    if(email_.isEmpty())
    {
        email.setError("enter valid email address")
        email.requestFocus()
        return
    }
    if(password_.isEmpty())
    {
        password.setError("enter valid email address")
        password.requestFocus()
        return
    }



    }
}