package com.example.navmanuapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.navigation.ui.NavigationUI
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.navmanuapp.databinding.ActivityNavigationViewBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class NavigationViewActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityNavigationViewBinding
    private lateinit var currentUser: FirebaseUser

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityNavigationViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarNavigationView.toolbar)

        var auth: FirebaseAuth=FirebaseAuth.getInstance()

        //function call to get username and email to show on header
        displayUserInfo(auth)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_navigation_view)


        // Load and display a rounded image in the header of NavigationView
//        val headerView = navView.getHeaderView(0)
//        val imageView: ImageView = headerView.findViewById(R.id.imageView)
//        Glide.with(this)
//            .load(R.drawable.profile) // Replace with your image resource or URL
//            .transform(CircleCrop()) // Apply circular transformation
//            .into(imageView)



        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_logout -> {
                    auth.signOut()
                    startActivity(Intent(this, Login::class.java))
                    finish()
                    true
                }
                R.id.restart_app ->{
                    startActivity(Intent(this,Signup::class.java))
                    finish()
                    true
                }
                R.id.close_app ->{
                   finishAffinity()
                    true
                }
                  else -> {
                // Perform fragment navigation for other menu items
                menuItem.isChecked = true
                drawerLayout.closeDrawers()
                val handled = NavigationUI.onNavDestinationSelected(menuItem, navController)
                handled || super.onOptionsItemSelected(menuItem)
            }
            }
        }
    }


    private fun displayUserInfo(auth: FirebaseAuth) {


        val userId = FirebaseAuth.getInstance().currentUser?.uid
        val dbRef = FirebaseDatabase.getInstance().getReference("Signup").child(userId.toString())

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val dbName = snapshot.child("name").getValue(String::class.java)
                    val dbEmail = snapshot.child("email").getValue(String::class.java)
                    val dbImage = snapshot.child("image").getValue(String::class.java)

                    val headerView = binding.navView.getHeaderView(0)
                    val userNameTextView: TextView = headerView.findViewById(R.id.userName)
                    val userEmailTextView: TextView = headerView.findViewById(R.id.userEmail)
                    val displayImage : ImageView = headerView.findViewById(R.id.imageView)

                    userNameTextView.text = dbName
                    userEmailTextView.text = dbEmail

                        Glide.with(this@NavigationViewActivity) // Use your activity reference
                            .load(dbImage)
                            .transform(CircleCrop()) // Apply circular transformation
                            .into(displayImage)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle an error in fetching the data
                val errorMessage = "Error: ${error.message}" // Get the error message from DatabaseError

                // Use applicationContext or pass a valid context to Toast.makeText()
                Toast.makeText(applicationContext, errorMessage, Toast.LENGTH_SHORT).show()
            }

        })

    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_navigation_view)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}