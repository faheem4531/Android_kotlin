package com.example.signupfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class Home : AppCompatActivity() {
    lateinit var tabBar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        tabBar=findViewById(R.id.tb_main)
        setSupportActionBar(tabBar)
    }


//OverRide to our menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)

        return true
    }

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
//                var signUp = Intent (this, SignUp::class.java)
//                startActivity(signUp)
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }


}