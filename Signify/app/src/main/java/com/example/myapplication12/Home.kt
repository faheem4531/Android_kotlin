package com.example.myapplication12

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.Signify.R

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    fun chrome(view: View) {
        var searchText = findViewById<EditText>  (R.id.search );
        var _searchText = searchText.text.toString();

        val Search = Intent(Intent.ACTION_VIEW);
        Search.setData(Uri.parse("https://www.google.com/search?q="+_searchText));
        startActivity(Search);
    }
}