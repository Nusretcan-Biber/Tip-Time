package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener { calgulateTip() }

    }
        fun calgulateTip(){
            val stringInTextField = binding.costOfServiceEditText.toString()
            val cost = stringInTextField.toDouble()
            val selectId = binding.tipOptions.checkedRadioButtonId

            val tipPercentage = when(selectId){
                R.id.option_twenty_percent -> 0.20
                R.id.options_fiftiin_percent -> 0.18
                else -> 0.15

            }
            var tip = tipPercentage * cost
            val roundUp = binding.roubndUpSwitch.isChecked
            if (roundUp){
                tip = kotlin.math.ceil(tip)

            }
           // NumberFormat.getCurrencyInstance()
            val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
            binding.tipResult.text= getString(R.string.tip_amount,formattedTip)
        }
}