package com.example.agecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    var selectedAgeTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button_age)
        selectedAgeTextView = findViewById(R.id.textview_selectedAge)
        button.setOnClickListener {
            makeDatePickerDialog()

        }
    }

    fun makeDatePickerDialog() {
        val calender = Calendar.getInstance()

        val dialog = DatePickerDialog(
            this,
            { _, year, month, day ->
                selectedAgeTextView?.text = "Selected age is : $year ${month + 1} $day"
            },
            calender.get(Calendar.YEAR),
            calender.get(Calendar.MONTH),
            calender.get(Calendar.DAY_OF_MONTH)
        )

        dialog.show()

    }
}