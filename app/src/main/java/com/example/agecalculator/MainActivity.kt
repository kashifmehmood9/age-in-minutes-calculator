package com.example.agecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    private var selectedAgeTextView: TextView? = null
    var ageInMinutesTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button_age)
        selectedAgeTextView = findViewById(R.id.textview_selectedAge)
        ageInMinutesTextView = findViewById(R.id.textview_age_in_minutes)
        button.setOnClickListener {
            makeDatePickerDialog()
        }
    }

    private fun makeDatePickerDialog() {
        val calender = Calendar.getInstance(Locale.ENGLISH)

        val dialog = DatePickerDialog(
            this,
            { datePicker, year, month, day ->
                DateCalculator().calculateDate(day, month, year)
            },
            calender.get(Calendar.YEAR),
            calender.get(Calendar.MONTH),
            calender.get(Calendar.DAY_OF_MONTH)
        )
        dialog.datePicker.maxDate = System.currentTimeMillis()
        dialog.show()
    }
}