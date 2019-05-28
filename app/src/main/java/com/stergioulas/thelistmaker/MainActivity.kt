package com.stergioulas.thelistmaker

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    // navigation listener
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_agenda -> {
                Toast.makeText(this, "Agenda", Toast.LENGTH_SHORT).show()
                replaceFragment(BlankFragment.newInstance(), R.id.container)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_lists -> {
                // TODO, similar to Timetree.
                Toast.makeText(this, "Lists", Toast.LENGTH_SHORT).show()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_settings -> {
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        supportActionBar!!.initLayout(R.layout.actionbar, this)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        navView.selectedItemId = R.id.navigation_agenda
    }

}

// Helper methods.

/**
 * FragmentManager extension, to always have a transaction when want to change fragment.
 */
private fun androidx.fragment.app.FragmentManager.inTransaction(lambdaFunc: androidx.fragment.app.FragmentTransaction.() -> Unit) {
    val fragmentTransaction = beginTransaction()
    fragmentTransaction.lambdaFunc()
    fragmentTransaction.commit()
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction { replace(frameId, fragment) }
}

fun ActionBar.initLayout(newLayout: Int, context: Context) {
    val mInflater = LayoutInflater.from(context)
    val mCustomview = mInflater.inflate(newLayout, null)

    this.customView = mCustomview

    this.setDisplayShowCustomEnabled(true)
    this.setDisplayShowHomeEnabled(false)
    this.setDisplayShowTitleEnabled(false)
}