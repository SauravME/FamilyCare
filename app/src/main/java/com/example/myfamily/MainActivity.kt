package com.example.myfamily


import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity: AppCompatActivity() {
    private val permissions  = arrayOf(
        android.Manifest.permission.CAMERA,
        android.Manifest.permission.READ_CONTACTS
    )
    private val permissionCode =67
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        askForPermission()
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

    private fun askForPermission() {
        ActivityCompat.requestPermissions(this,permissions,permissionCode)
    }

// to open the camera inside our main activity
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if(requestCode==permissionCode){
//            if(allPermissionGranted()){
//                opencamera()
//            }
//            else{
//                Toast.makeText(this, "Permission not granted", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }

//    private fun opencamera() {
//        val intent = Intent("android.media.action.IMAGE_CAPTURE")
//        startActivity(intent)
//    }

//    private fun allPermissionGranted(): Boolean {
//        for(item in permissions){
//            if(ContextCompat.checkSelfPermission(this,item)!=PackageManager.PERMISSION_GRANTED){
//                return false
//            }
//        }
//        return true
//    }

    private fun inflateFragment(newInstance:Fragment) {
        val transaction =supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,newInstance)
        transaction.commit()
    }
}