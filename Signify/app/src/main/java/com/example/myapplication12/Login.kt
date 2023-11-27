package com.example.myapplication12

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import com.example.Signify.MainActivity
import com.example.Signify.R


import android.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat


class Login : AppCompatActivity() {
    //get ToolBar
    lateinit var tabBar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

//        set menu to toolbar
        tabBar=findViewById(R.id.tb_main)
        setSupportActionBar(tabBar)
    }

    //OverRide to our menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        menu?.let { actualMenu ->
            val searchItem = actualMenu.findItem(R.id.search)
            val searchView = searchItem.actionView as? SearchView

            searchView?.apply {
                queryHint = "Search "
                // Set listeners or handle search functionality
            }
        }

        return true
    }



    //Menu items click activity function
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.close_app -> {
                finishAffinity()
            }
            R.id.restar_app -> {
                var restartApp = Intent(this,MainActivity::class.java)
                startActivity(restartApp)
                finish()
                return true
            }
            R.id.signup -> {
                var signUp = Intent (this, SignUp::class.java)
                startActivity(signUp)
                return true
            }
            R.id.directLogin->{
                var dirrectHome = Intent (this, Home::class.java)
                startActivity(dirrectHome)
            }
        }

        return super.onOptionsItemSelected(item)
    }






//    handle Login
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



    //Handle Signup
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

