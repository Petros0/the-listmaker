package com.stergioulas.thelistmaker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.applandeo.materialcalendarview.CalendarView

class CalendarFragment : androidx.fragment.app.Fragment() {
    private lateinit var mCalendarView: CalendarView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_calendar, container, false)
        mCalendarView = view.findViewById(R.id.calendarView)
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = CalendarFragment()
    }
}