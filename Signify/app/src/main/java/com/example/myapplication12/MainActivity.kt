package com.example.Signify

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.myapplication12.Home
import com.example.myapplication12.Login
import com.example.myapplication12.SignUp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Handler(Looper.getMainLooper()).postDelayed({
        var intent=Intent(this,Login::class.java)
            startActivity(intent)
        },3000)



    }
}