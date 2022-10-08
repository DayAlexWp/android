package com.wccnet.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wccnet.tipcalculator.databinding.ActivityMainBinding
import java.lang.NumberFormatException
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //submit button listener
        binding.submitButton.setOnClickListener {
            //init var for user info
            var num = 0.0

            //gets user info and converts to double for math
            //.toDouble throws exception when string is empty
            try {
                num = binding.inputField.text.toString().toDouble()
            } catch (e: NumberFormatException) {
                binding.mainText.setText("Enter a Value First!")
            }

            //checks if num has been altered
            //displays calculated totals using numCruncher method
            if (num != 0.0) {
                binding.mainText.setText("15%: " + numCruncher(num, 1.15)
                        + " 20%: " + numCruncher(num, 1.20)
                        + " 25%: " + numCruncher(num, 1.25))
            }
        }
    }

    //takes in base number and returns it multiplied by the second value
    //rounds to two decimal places
    fun numCruncher (base: Double, mult: Double): Double {
        return ((base * mult) * 100).roundToInt() / 100.0
    }
}