package com.stergioulas.thelistmaker

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class CalendarFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_calendar, container, false)


        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = CalendarFragment()
    }
}