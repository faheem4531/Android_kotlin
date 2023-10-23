package com.example.Signify

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.RadioButton
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.myapplication12.SignUp
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @RequiresApi(Build.VERSION_CODES.O)
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

        }
    }

    fun signUP (view: View){
//        var email = findViewById<TextView>(R.id.mail)
//        var password = findViewById<TextView>(R.id.pass)

        // Clear all the fields
//        email.text = null
//        password.text = null

        val Intent = Intent(this, SignUp::class.java)
        startActivity(Intent);
    }
}