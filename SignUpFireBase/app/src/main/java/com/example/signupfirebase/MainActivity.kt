package com.example.signupfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

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
    var name =     findViewById<EditText> (R.id.name_id)
    var email =    findViewById<EditText> (R.id.email_id)
    var password = findViewById<EditText> (R.id.password_id)

//    convert to string
    var name_ =     name.text.toString()
    var email_ =    email.text.toString()
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


//    Send data to firebase
    val auth:FirebaseAuth= FirebaseAuth.getInstance()

    var progress = findViewById<LinearLayout>  (R.id.progress_id)
    var form =     findViewById<LinearLayout>  (R.id.form_container)

    form.visibility =     View.GONE
    progress.visibility = View.VISIBLE

    auth.createUserWithEmailAndPassword(email_,password_).addOnCompleteListener(){

        form.visibility=View.VISIBLE
        progress.visibility=View.GONE

        if (it.isSuccessful) {
            Toast.makeText(this, "Signup Successful", Toast.LENGTH_SHORT).show()
            name.text = null
            email.text = null
            password.text = null
        }
        else
            Toast.makeText(this,"Signup Fail",Toast.LENGTH_SHORT).show()
    }


    }
}




















