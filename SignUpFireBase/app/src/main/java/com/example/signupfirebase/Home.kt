package com.example.signupfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        var tabBar = findViewById<Toolbar>(R.id.tb_main)
        var intent=intent
        var user=intent.getStringExtra("mail")
        tabBar.title = user
        setSupportActionBar(tabBar)


        val title = tabBar.getChildAt(0) as? TextView
        title?.let {
            it.textSize = 18f // Set font size to 15sp
        }



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
            R.id.logout -> {
                startActivity(Intent(this,Signin::class.java))
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }


}