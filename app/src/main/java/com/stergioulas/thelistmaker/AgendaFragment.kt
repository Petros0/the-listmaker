package com.stergioulas.thelistmaker

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BlankFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class BlankFragment : androidx.fragment.app.Fragment() {

    private var listener: OnFragmentInteractionListener? = null
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_agenda, container, false)

        recyclerView = view.findViewById(R.id.recycler_view)

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = RecyclerView.VERTICAL
        recyclerView.layoutManager = layoutManager

        val listOf = listOf("Bla", "bla", "bla", "bla")

        val adapter = ListAdapter(listOf)

        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(
            androidx.recyclerview.widget.DividerItemDecoration(
                recyclerView.context,
                layoutManager.orientation
            )
        )

        return view
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var textViewDayOfWeek: TextView = itemView.findViewById<View>(R.id.day_of_week_textview) as TextView
        internal var textviewDateNumber: TextView = itemView.findViewById<View>(R.id.date_number_textview) as TextView
    }

    class ListAdapter(private val list: List<String>) :
        RecyclerView.Adapter<ViewHolder>() {

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {

            val view = LayoutInflater.from(p0.context).inflate(R.layout.fragment_agenda_item, p0, false)

            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return this.list.size
        }

        override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
            p0.textViewDayOfWeek.text = "Bla"
            p0.textviewDateNumber.text = "Blo"
        }
    }
}
