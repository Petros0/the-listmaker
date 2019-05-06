@file:Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

package com.stergioulas.thelistmaker

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                textMessage.setText(R.string.title_agenda)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                textMessage.setText(R.string.title_lists)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                textMessage.setText(R.string.title_settings)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val mActionBar = supportActionBar
        mActionBar!!.setDisplayShowHomeEnabled(false)
        mActionBar.setDisplayShowTitleEnabled(false)

        val mInflater = LayoutInflater.from(this)
        val mCustomview = mInflater.inflate(R.layout.actionbar, null)

        mActionBar.customView = mCustomview
        mActionBar.setDisplayShowCustomEnabled(true)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }
}
