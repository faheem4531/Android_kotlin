package com.example.signupfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Signin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

       var requestBtn = findViewById<Button>(R.id.signin_btn)

        requestBtn.setOnClickListener{
            signin_with_firebase()
        }
    }

    private fun signin_with_firebase(){

//    decleration
        var email =    findViewById<EditText> (R.id.signin_email_id)
        var password = findViewById<EditText> (R.id.signin_password_id)

//    convert to string
        var email_ =    email.text.toString()
        var password_ = password.text.toString()


//    Validation
        if(email_.isEmpty())
        {
            email.setError("enter correct email address")
            email.requestFocus()
            return
        }
        if(password_.isEmpty())
        {
            password.setError("enter correct email address")
            password.requestFocus()
            return
        }


//    Send data to firebase
        val auth: FirebaseAuth = FirebaseAuth.getInstance()

        var progress = findViewById<LinearLayout>  (R.id.signin_progress_id)
        var form =     findViewById<LinearLayout>  (R.id.signin_form_container)

        form.visibility =     View.GONE
        progress.visibility = View.VISIBLE

        auth.signInWithEmailAndPassword(email_,password_).addOnCompleteListener(){

            form.visibility= View.VISIBLE
            progress.visibility= View.GONE

            if (it.isSuccessful) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
            }
            else
                Toast.makeText(this,"Login Fail: "+it.exception, Toast.LENGTH_SHORT).show()
        }
    }


}