package com.example.Signify

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.myapplication12.Home
import com.example.myapplication12.SignUp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun login(view: View) {
//        declaration
        var email =       findViewById<TextView>     (R.id.mail);
        var password =    findViewById<TextView>     (R.id.pass);
        var output =      findViewById<TextView>     (R.id.tvOutput);

//        convert to string
        var _mail =      email.text.toString();
        var _password =  password.text.toString();


        if (_mail.length < 1)
            output.setText("Enter Email!");

        else if ( _password.length < 1 )
            output.setText("Enter Password!");

        else {
            output.setText("");
            val HomePage = Intent(this,Home::class.java)
            startActivity(HomePage);
        }
    }

    fun signUP (view: View){

        val Signup = Intent(this, SignUp::class.java)
        startActivity(Signup);

        var email = findViewById<TextView>(R.id.mail)
        var password = findViewById<TextView>(R.id.pass)

        // Clear all the fields
        email.text = null
        password.text = null
    }
}