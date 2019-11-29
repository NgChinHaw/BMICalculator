package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<View>(R.id.cal)

        btn.setOnClickListener(){

            // val carLoan:Double = price-downP
            //val interest =  carLoan* interestR/100 *loan
            //val monthly = (carLoan+interest)/loan/12

            try {

                val weight: Double = weightInput.text.toString().toDouble()
                val height: Double = heightInput.text.toString().toDouble()

                val bmiCal: Double = weight / pow(height, 2.0)
                val showStat: String = ""

                bmi.text = "BMI = %.2f".format(bmiCal)
                stats.text = "%s".format(showStat)

                if (bmiCal < 18.5) {
                    img.setImageResource(R.drawable.under)
                    stats.text = getString(R.string.underW)
                } else if (bmiCal >= 18.5 && bmiCal < 25.0) {
                    img.setImageResource(R.drawable.normal)
                    stats.text = getString(R.string.norma)
                } else if (bmiCal >= 25) {
                    img.setImageResource(R.drawable.over)
                    stats.text = getString(R.string.overW)
                }

            }catch(ex:Exception){
                val toast:Toast = Toast.makeText(this, "Invalid input", Toast.LENGTH_LONG)

                toast.setGravity(Gravity.CENTER, 0, 0)

                toast.show()
            }

        }

        reseto.setOnClickListener(){
            img.setImageResource(R.drawable.empty)
            stats.text = ""
            bmi.text = ""
        }


    }
}
