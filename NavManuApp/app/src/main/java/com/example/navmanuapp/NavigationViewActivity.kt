package com.example.navmanuapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.NavigationUI
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.navmanuapp.databinding.ActivityNavigationViewBinding

class NavigationViewActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityNavigationViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavigationViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarNavigationView.toolbar)





        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_navigation_view)


        // Load and display a rounded image in the header of NavigationView
        val headerView = navView.getHeaderView(0)
        val imageView: ImageView = headerView.findViewById(R.id.imageView)
        Glide.with(this)
            .load(R.drawable.profile) // Replace with your image resource or URL
            .transform(CircleCrop()) // Apply circular transformation
            .into(imageView)



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
                    startActivity(Intent(this, Login::class.java))
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



    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_navigation_view)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}