package com.stergioulas.thelistmaker

import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    // navigation listener
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_agenda -> {
                Toast.makeText(this, "Agenda/Home", Toast.LENGTH_SHORT).show()
                replaceFragment(CalendarFragment.newInstance(), R.id.container)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_lists -> {
                Toast.makeText(this, "Lists", Toast.LENGTH_SHORT).show()
                replaceFragment(BlankFragment.newInstance(), R.id.container)
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

        supportActionBar!!.changeLayout(R.layout.actionbar, this)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        navView.selectedItemId = R.id.navigation_agenda
    }

}

/**
 * FragmentManager extension, to always have a transaction when want to change fragment.
 */

private fun FragmentManager.inTransaction(lambdaFunc: FragmentTransaction.() -> Unit) {
    val fragmentTransaction = beginTransaction()
    fragmentTransaction.lambdaFunc()
    fragmentTransaction.commit()
}

/**
 *
 */
fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction { add(frameId, fragment) }
}


fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction { replace(frameId, fragment) }
}

fun ActionBar.changeLayout(newLayout: Int, context: Context) {
    val mInflater = LayoutInflater.from(context)
    val mCustomview = mInflater.inflate(newLayout, null)

    this.customView = mCustomview

    this.setDisplayShowCustomEnabled(true)
    this.setDisplayShowHomeEnabled(false)
    this.setDisplayShowTitleEnabled(false)
}