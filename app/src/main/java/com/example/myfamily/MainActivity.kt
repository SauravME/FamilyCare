package com.example.myfamily


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       val bottomBar = findViewById<BottomNavigationView>(R.id.bottomBar)
        bottomBar.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.navSecurity -> {
                    inflateFragment(GuardFragment.newInstance())
                }
                R.id.navHome -> {

                    inflateFragment(HomeFragment.newInstance())
                }
                R.id.navDashboard -> {
                    inflateFragment(DashboardFragment.newInstance())
                }
                R.id.navUser -> {
                    inflateFragment(UserFragment.newInstance())
                }
            }


            true
        }
        bottomBar.selectedItemId= R.id.navHome


    }



    private fun inflateFragment(newInstance:Fragment) {
        val transaction =supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,newInstance)
        transaction.commit()
    }
}