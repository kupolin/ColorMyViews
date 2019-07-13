package me.jonlin.android.colormyviews

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import me.jonlin.android.colormyviews.databinding.ActivityMainBinding
import java.lang.ref.WeakReference

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    // data binder variable later create some kind of data class to pass xml variables.

    companion object {
        lateinit var act: WeakReference<Activity>
        fun getActivity(): Activity? = act.get()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivity.act = WeakReference(this)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setBindings()
        setListeners()
    }

    private fun setBindings() {
        binding.textBoxesVar = DataBindingVars.setColorBG(null, Color.MAGENTA)
    }

    private fun setListeners(): Unit {
        val clickableViews: List<View> = listOf(
            binding.boxOneText,
            binding.boxTwoText,
            binding.boxThreeText,
            binding.boxFourText,
            binding.boxFiveText,
            binding.constraintLayout,
            binding.redButton,
            binding.yellowButton,
            binding.greenButton
        )

//        val map: HashMap<Int, Int> = hashMapOf(1 to 2, 3 to 5)
//        val oneVal = map[1]

        for (i in clickableViews) {
            i.setOnClickListener { setBackgroundColor(it) }
        }
    }

    /*
        private fun setBackgroundColor(view: View) {
            when (view.id) {
                R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
                R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)
                R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
                R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
                R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)
                else -> view.setBackgroundColor(Color.LTGRAY)
            }
        }
        */
    private fun setBackgroundColor(view: View) {
        when (view.id) {
            R.id.box_one_text -> binding.boxOneText.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> binding.boxTwoText.setBackgroundColor(Color.GRAY)
            R.id.box_three_text -> binding.boxThreeText.setBackgroundResource(R.drawable.ic_launcher_background)
            R.id.box_four_text -> binding.boxFourText.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> binding.boxFiveText.setBackgroundResource(android.R.color.holo_green_light)
            R.id.red_button -> binding.boxThreeText.setBackgroundColor(Color.RED)
            R.id.yellow_button -> binding.boxFourText.setBackgroundColor(Color.YELLOW)
            R.id.green_button -> binding.boxFiveText.setBackgroundColor(Color.GREEN)
            else -> binding.constraintLayout.setBackgroundColor(Color.LTGRAY)
        }
        binding.invalidateAll()
    }
}
