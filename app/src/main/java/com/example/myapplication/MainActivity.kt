package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener(onBottomNavigationViewItemSelectedListener())
        // Starting tab bottom bar selected
        bottom_navigation.selectedItemId = R.id.nav_home
    }

    private fun onBottomNavigationViewItemSelectedListener(): BottomNavigationView.OnNavigationItemSelectedListener {
        return BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    setContentLayout(CarListFragment(), CarListFragment.TAG)
                    true
                }
                R.id.nav_favorite -> {
                    setContentLayout(FavoriteFragment(), FavoriteFragment.TAG)
                    true
                }
                R.id.nav_settings -> {
                    setContentLayout(SettingsFragment(), SettingsFragment.TAG)
                    true
                }

                else -> false
            }
        }
    }

    private fun setContentLayout(fragment: Fragment, tag: String) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, fragment, tag).commit()
    }
}
