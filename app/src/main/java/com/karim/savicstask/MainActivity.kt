package com.karim.savicstask

import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
//        navView.setNavigationItemSelectedListener { item ->
//
//            when (item.itemId) {
//                R.id.nav_home -> {
//                    val fragment = HomeFragment()
////                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, fragment)
////                        .addToBackStack(null)
////                        .commit()
//                    val transaction = supportFragmentManager.beginTransaction()
//                    transaction.replace(R.id.nav_host_fragment, fragment, fragment.javaClass.getSimpleName())
//                        .addToBackStack(null)
//                    transaction.commit()
//                    true
//
//                }
//                R.id.nav_gallery -> {
//                    val fragment = GalleryFragment()
////                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, fragment)
////                    .addToBackStack(null)
////                    .commit()
//
//                    val transaction = supportFragmentManager.beginTransaction()
//                    transaction.replace(R.id.nav_host_fragment, fragment, fragment.javaClass.getSimpleName())
//                        .addToBackStack(null)
//
//                    transaction.commit()
//                    true
//
//                }
//                R.id.nav -> {
//                    // handle click
//                    try {
//                        val txt = " i didi good. i like it!".trimIndent()
//                        val sendEmail = Intent(Intent.ACTION_SEND)
//                        sendEmail.data = Uri.parse("mailto:")
//                        sendEmail.type = "message/rfc822"
//                        sendEmail.putExtra(Intent.EXTRA_EMAIL, "myandguestuser@gmail.com")
//                        sendEmail.putExtra(Intent.EXTRA_SUBJECT, "Savics Android test")
//                        sendEmail.putExtra(Intent.EXTRA_TEXT, txt)
//                        startActivity(sendEmail)
//                    } catch (e: Exception) {
//
//                    }
//
//
//                    true
//                }
//                else -> false
//            }
//        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_reset) {
            val sharedPreference = getSharedPreferences("SavicsTask", Context.MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.clear()
            editor.apply()
            Toast.makeText(this, "Data cleared", Toast.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}