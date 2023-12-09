package com.example.navmanuapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import android.widget.ImageView


class Signup<ImageView : View> : AppCompatActivity() {
    private lateinit var dbRef:DatabaseReference
    private val PICK_IMAGE_REQUEST = 1
    private lateinit var selectedImageUri: Uri


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        supportActionBar?.hide()

        var signUpBtn = findViewById <Button>  (R.id.signup_btn)
        var imageBtn = findViewById  <Button>  (R.id.imagePikerBtn)

        imageBtn.setOnClickListener {
            openGallery()
        }
        signUpBtn.setOnClickListener(){
//            post_signup_data_to_firebase()
        }
    }





    private fun post_signup_data_to_firebase() {

//    decleration
        var name =     findViewById<EditText> (R.id.name_id)
        var email =    findViewById<EditText> (R.id.email_id)
        var password = findViewById<EditText> (R.id.password_id)

//    convert to string
        var name_ =     name.text.toString()
        var email_ =    email.text.toString()
        var password_ = password.text.toString()



//    Validation
        if(name_.isEmpty())
        {
            name.setError("enter your name")
            name.requestFocus()
            return
        }
        if(email_.isEmpty())
        {
            email.setError("enter valid email address")
            email.requestFocus()
            return
        }
        if(password_.isEmpty())
        {
            password.setError("enter valid email address")
            password.requestFocus()
            return
        }






//    Send data to firebase
        val auth: FirebaseAuth = FirebaseAuth.getInstance()

        var progress = findViewById<LinearLayout>  (R.id.progress_id)
        var form =     findViewById<LinearLayout>  (R.id.form_container)

        form.visibility =     View.GONE
        progress.visibility = View.VISIBLE

        auth.createUserWithEmailAndPassword(email_,password_).addOnCompleteListener(){

            form.visibility=View.VISIBLE
            progress.visibility=View.GONE

            if (it.isSuccessful) {


                //     Store user Data in DB
                val userId = FirebaseAuth.getInstance().currentUser?.uid
                dbRef=FirebaseDatabase.getInstance().getReference("Signup").child(userId.toString())
                val signupDetails = SignupClass(name_,email_)
                dbRef.setValue(signupDetails)

                //Toster
                Toast.makeText(this, "Signup Successful", Toast.LENGTH_SHORT).show()
                name.text = null
                email.text = null
                password.text = null
                var home = Intent(this,NavigationViewActivity::class.java)
                startActivity(home)
            }
            else
                Toast.makeText(this,"Signup Fail : " +it.exception,Toast.LENGTH_SHORT).show()
        }
    }

    fun signinIntent(view: View){
        startActivity(Intent(this, Login::class.java))
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val imageBtn = findViewById<Button>(R.id.imagePikerBtn)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            val selectedImageUri = data.data!!
            val showImageX = findViewById<android.widget.ImageView>(R.id.signupImageShow)
            showImageX.visibility = View.VISIBLE
            imageBtn.visibility = View.GONE

            Glide.with(this)
                .load(selectedImageUri)
                .into(showImageX)

            // Now you can also proceed to upload the image to Firebase if needed
            // uploadImageToFirebase(selectedImageUri)
        }
    }





}


class SignupClass( name_: String, email_: String) {
    var name:String=""
    var email:String=""
    init {
        this.name = name_
        this.email = email_
    }
}
