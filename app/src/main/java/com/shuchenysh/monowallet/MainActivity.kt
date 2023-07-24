package com.shuchenysh.monowallet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupWithNavController
import com.shuchenysh.monowallet.databinding.ActivityMainBinding
import com.shuchenysh.monowallet.screens.AddFragment
import com.shuchenysh.monowallet.screens.HomeFragment
import com.shuchenysh.monowallet.screens.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navController = navHostFragment.navController
        val bottomNavigationView = binding.bottomNavViewMain
        setupWithNavController(bottomNavigationView, navController)

//        binding.bottomNavViewMain.setOnItemSelectedListener {
//            when (it.itemId) {
//                R.id.add -> replaceFragment(AddFragment())
//                R.id.home -> replaceFragment(HomeFragment())
//                R.id.profile -> replaceFragment(ProfileFragment())
//                else -> {
//                }
//            }
//            true
//        }
//    }
//
// //   private fun replaceFragment(fragment: Fragment) {
//   //     val fragmentManager = supportFragmentManager
//     //   val fragmentTransaction = fragmentManager.beginTransaction()
//       // fragmentTransaction.replace(R.id.fragment_container_view, fragment)
//        //fragmentTransaction.commit()
//    //}
    }
}






















