package com.example.Calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun num1(view: View) {
        if(findViewById<TextView>(R.id.textbox1).text.toString().isEmpty()){
            var one = 1;
            var out = findViewById<TextView>(R.id.textbox1);
            out.text=one.toString();
        }
        else
        {
            var one=1;
            var out = findViewById<TextView>(R.id.textbox2);
            out.text=one.toString();
        }
    }

    fun num2(view: View) {
        if(findViewById<TextView>(R.id.textbox1).text.toString().isEmpty()){
            var two = 2;
            var out = findViewById<TextView>(R.id.textbox1);
            out.text=two.toString();
        }
        else
        {
            var two=2;
            var out = findViewById<TextView>(R.id.textbox2);
            out.text=two.toString();
        }
    }

    fun num3(view: View) {
        if(findViewById<TextView>(R.id.textbox1).text.toString().isEmpty()){
            var three = 3;
            var out = findViewById<TextView>(R.id.textbox1);
            out.text=three.toString();
        }
        else
        {
            var three=3;
            var out = findViewById<TextView>(R.id.textbox2);
            out.text=three.toString();
        }
    }

    fun num4(view: View) {
        if(findViewById<TextView>(R.id.textbox1).text.toString().isEmpty()){
            var four = 4;
            var out = findViewById<TextView>(R.id.textbox1);
            out.text=four.toString();
        }
        else
        {
            var four=4;
            var out = findViewById<TextView>(R.id.textbox2);
            out.text=four.toString();
        }
    }

    fun num5(view: View) {
        if(findViewById<TextView>(R.id.textbox1).text.toString().isEmpty()){
            var five = 5;
            var out = findViewById<TextView>(R.id.textbox1);
            out.text=five.toString();
        }
        else
        {
            var five=5;
            var out = findViewById<TextView>(R.id.textbox2);
            out.text=five.toString();
        }

    }

    fun num6(view: View) {
        if(findViewById<TextView>(R.id.textbox1).text.toString().isEmpty()){
            var six = 6;
            var out = findViewById<TextView>(R.id.textbox1);
            out.text=six.toString();
        }
        else
        {
            var six=6;
            var out = findViewById<TextView>(R.id.textbox2);
            out.text=six.toString();
        }
    }

    fun num7(view: View) {
        if(findViewById<TextView>(R.id.textbox1).text.toString().isEmpty()){
            var seven= 7;
            var out = findViewById<TextView>(R.id.textbox1);
            out.text=seven.toString();
        }
        else
        {
            var seven=7;
            var out = findViewById<TextView>(R.id.textbox2);
            out.text=seven.toString();
        }
    }
    fun num8(view: View) {
        if(findViewById<TextView>(R.id.textbox1).text.toString().isEmpty()){
            var eight = 8;
            var out = findViewById<TextView>(R.id.textbox1);
            out.text=eight.toString();
        }
        else
        {
            var eight=8;
            var out = findViewById<TextView>(R.id.textbox2);
            out.text=eight.toString();
        }
    }
    fun num9(view: View) {
        if(findViewById<TextView>(R.id.textbox1).text.toString().isEmpty()){
            var nine = 9;
            var out = findViewById<TextView>(R.id.textbox1);
            out.text=nine.toString();
        }
        else
        {
            var nine=9;
            var out = findViewById<TextView>(R.id.textbox2);
            out.text=nine.toString();
        }
    }
    fun num0(view: View) {
        if(findViewById<TextView>(R.id.textbox1).text.toString().isEmpty()){
            var zero = 0;
            var out = findViewById<TextView>(R.id.textbox1);
            out.text=zero.toString();
        }
        else
        {
            var zero=0;
            var out = findViewById<TextView>(R.id.textbox2);
            out.text=zero.toString();
        }
    }

    fun add(view: View) {
        var boxx1=findViewById<TextView>(R.id.textbox1).text.toString();
        var num1=boxx1.toInt();
        var boxx2=findViewById<TextView>(R.id.textbox2).text.toString();
        var num2=boxx2.toInt();
        var result = num1 + num2;
        var out=findViewById<TextView>(R.id.resultbox);
        out.text="$num1 + $num2 = $result";
    }

    fun min(view: View) {
        var boxx1=findViewById<TextView>(R.id.textbox1).text.toString();
        var num1=boxx1.toInt();
        var boxx2=findViewById<TextView>(R.id.textbox2).text.toString();
        var num2=boxx2.toInt();
        var result = num1 - num2;
        var out=findViewById<TextView>(R.id.resultbox);
        out.text="$num1 - $num2 = $result";
    }

    fun div(view: View) {
        var boxx1=findViewById<TextView>(R.id.textbox1).text.toString();
        var num1=boxx1.toInt();
        var boxx2=findViewById<TextView>(R.id.textbox2).text.toString();
        var num2=boxx2.toInt();
        var result = num1 / num2;
        var out=findViewById<TextView>(R.id.resultbox);
        out.text="$num1 / $num2 = $result";
    }

    fun mul(view: View) {
        var boxx1=findViewById<TextView>(R.id.textbox1).text.toString();
        var num1=boxx1.toInt();
        var boxx2=findViewById<TextView>(R.id.textbox2).text.toString();
        var num2=boxx2.toInt();
        var result = num1 * num2;
        var out=findViewById<TextView>(R.id.resultbox);
        out.text="$num1 * $num2 = $result";
    }

    fun clear(view: View) {
        val textView1=findViewById<TextView>(R.id.textbox1);
        val textView2=findViewById<TextView>(R.id.textbox2);
        val textView3=findViewById<TextView>(R.id.resultbox);
        textView1.text = "";
        textView2.text = "";
        textView3.text = "";
    }
}