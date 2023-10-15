package com.example.Signify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun signUpUser(view: View) {
        var etName = findViewById<TextView>   (R.id.etName);
        var cbCric = findViewById<CheckBox>    (R.id.cbCricket);
        var cbFootball = findViewById<CheckBox> (R.id.cbFootball);
        var cbHockey = findViewById<CheckBox>  (R.id.cbHockey);
        var output = findViewById<TextView>  (R.id.tvOutput);

        var str = etName.text.toString();

        if (findViewById<RadioButton>(R.id.rbFemale).isChecked)
            str = str + "Gender = Female"
        else
            if (findViewById<RadioButton>(R.id.rbMale).isChecked)
                str = str + "Gender = Male"


        var hobbies = "Your Hobbies are";

        if ( cbCric.isChecked )
            hobbies = hobbies + "Cricket";

        if ( cbHockey.isChecked )
            hobbies = hobbies + "Hockey" ;

        if ( cbFootball.isChecked )
            hobbies = hobbies + "Football" ;



        if (hobbies.toString().length < 18 )
            output.setText("Dear" + str + "You don't Checked any box");

        else
            output.setText("Dear " + str + hobbies);
    }
}