package me.jonlin.android.colormyviews

import android.graphics.Color
import android.view.View
import android.widget.TextView

data class DataBindingVars(var textBox: TextView, var color: Int = Color.BLUE) {
    constructor (color: Int) : this(MainActivity.getActivity()!!.findViewById(R.id.constraint_layout), color)

    //messing around
    companion object {

        //pass in a ViewGroup. or root layout
        fun setColorBackground(view: View?, color: Int): DataBindingVars =
            DataBindingVars(view?.let { it as TextView }
                ?: MainActivity.getActivity()!!.findViewById(R.id.box_one_text), color)

        /* :*((((f
                fun test(){
                    DataBindingVars.setColorBG(_, Color.BLUE)
                }
                */
        fun setColorBG(view: View? = null, color: Int): DataBindingVars = DataBindingVars(view?.let { it as TextView }
            ?: MainActivity.getActivity()!!.findViewById(R.id.box_one_text), color)
    }
}