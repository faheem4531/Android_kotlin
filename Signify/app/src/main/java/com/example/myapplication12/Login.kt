package com.example.myapplication12

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.TextView
import com.example.Signify.R

class Login : AppCompatActivity() {
    //get ToolBar
    lateinit var tabBar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tabBar=findViewById(R.id.tb_main)
        setSupportActionBar(tabBar)
    }

    //OverRide our tabBar to menu.xml
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
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
            HomePage.putExtra("mail",_mail)
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