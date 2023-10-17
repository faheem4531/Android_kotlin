package com.example.Signify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.RadioButton
import android.widget.Switch
import android.widget.TextView
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.Period


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun signUpUser(view: View) {
//        declaration
        var etName =      findViewById<TextView>     (R.id.name);
        var email =       findViewById<TextView>     (R.id.mail);
        var password =    findViewById<TextView>     (R.id.pass);
        var confirmPass = findViewById<TextView>     (R.id.confirmPass);
        var male =        findViewById<RadioButton>  (R.id.rbMale);
        var female =      findViewById<RadioButton>  (R.id.rbFemale);
        var cbCric =      findViewById<CheckBox>     (R.id.cbCricket);
        var cbFootball =  findViewById<CheckBox>     (R.id.cbFootball);
        var cbHockey =    findViewById<CheckBox>     (R.id.cbHockey);
        var dateView =    findViewById<DatePicker>   (R.id.datePiker);
        var city =        findViewById<TextView>     (R.id.city);
        var country =     findViewById<TextView>     (R.id.country);
        var skillBegin =  findViewById<RadioButton>  (R.id.begin);
        var skillPro =    findViewById<RadioButton>  (R.id.advance);
        var agrement =    findViewById<CheckBox>     (R.id.agrement);
        var output =      findViewById<TextView>     (R.id.tvOutput);

//        convert to string
        var _name =      etName.text.toString();
        var _mail =      email.text.toString();
        var _password =  password.text.toString();
        var _confrmPas = confirmPass.text.toString();
        var _city =      city.text.toString();
        var _country =   country.text.toString();
        var _gender =   "Gender: ";

//       date of birth check
        var date = dateView.dayOfMonth
        var mon = dateView.month+1;
        var year = dateView.year

        var user_date = date.toString() +"/" + mon.toString() +"/" + year.toString();

        val currentDate = LocalDate.now().toString()

        output.setText(currentDate);






//        Gender check
        if (female.isChecked)
            _gender =_gender+ " Female"
        else if (male.isChecked)
            _gender = _gender + " Male"

//           Sports check
        var hobbies = "";
        if ( cbCric.isChecked )
            hobbies = hobbies + " Cricket";

        if ( cbHockey.isChecked )
            hobbies = hobbies + " Hockey" ;

        if ( cbFootball.isChecked )
            hobbies = hobbies + " Football" ;



//             Skills check
        var skills = "";
        if (skillBegin.isChecked)
            skills = "beginner."
        else if (skillPro.isChecked)
            skills = "advance."



//        if (_name.length<1 || (_password.length<1) || (_city.length<1) || (_country.length<1) || (_mail.length<1))
//            output.setText("Error! Fill above all fields");
//        else if(true)
//            output.setText("Error! You are under 18");
//        else if (_password != _confrmPas );
//            output.setText("Error! Password not match");
//        else if (!female.isChecked && !male.isChecked)
//            output.setText("Select your gender");
//        else if (hobbies.length<1)
//            output.setText("Select atleast one Sport");
//        else if (!skillBegin.isChecked && !skillPro.isChecked)
//            output.setText("Error! Chose your skill level");
//        else if (!agrement.isChecked )
//            output.setText("Please check the terms and condition");
//        else
//            output.setText(
//                "Welcome " + _name +",\n "
//                + _mail+",\n"
//                +_gender + ",\n"
//                + "born: "+_dateView+",\n"
//                +_city+", "+_country+".\n"
//                +"sports " + hobbies + ",\n"
//                +"Skills " +skills
//            );

    }

    fun clearData (view: View){
        var etName = findViewById<TextView>(R.id.name)
        var email = findViewById<TextView>(R.id.mail)
        var password = findViewById<TextView>(R.id.pass)
        var confirmPass = findViewById<TextView>(R.id.confirmPass)
        var male = findViewById<RadioButton>(R.id.rbMale)
        var female = findViewById<RadioButton>(R.id.rbFemale)
        var cbCric = findViewById<CheckBox>(R.id.cbCricket)
        var cbFootball = findViewById<CheckBox>(R.id.cbFootball)
        var cbHockey = findViewById<CheckBox>(R.id.cbHockey)
        var birth = findViewById<TextView>(R.id.birth)
        var city = findViewById<TextView>(R.id.city)
        var country = findViewById<TextView>(R.id.country)
        var skillBegin = findViewById<RadioButton>(R.id.begin)
        var skillPro = findViewById<RadioButton>(R.id.advance)
        var agrement = findViewById<CheckBox>(R.id.agrement)
        var output = findViewById<TextView>(R.id.tvOutput)

        // Clear all the fields
        etName.text = null
        email.text = null
        password.text = null
        confirmPass.text = null
        male.isChecked = false
        female.isChecked = false
        cbCric.isChecked = false
        cbFootball.isChecked = false
        cbHockey.isChecked = false
        birth.text = null
        city.text = null
        country.text = null
        skillBegin.isChecked = false
        skillPro.isChecked = false
        agrement.isChecked = false
        output.text = null
    }

    fun handleToggle (view: View){
        var switch = findViewById<Switch>  (R.id.switchView);
        var dateView =findViewById<DatePicker>  (R.id.datePiker);
        if (!switch.isChecked){
            dateView.calendarViewShown = true
            dateView.spinnersShown = false
            dateView.visibility = View.VISIBLE
        }
        else{
            dateView.calendarViewShown = false
            dateView.spinnersShown = true
            dateView.visibility = View.VISIBLE
        }
    }
}