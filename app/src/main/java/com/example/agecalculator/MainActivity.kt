package com.example.agecalculator

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.LocalDate
import java.time.format.DateTimeFormatter
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

    @RequiresApi(Build.VERSION_CODES.O)
    fun makeDatePickerDialog() {
        val calender = Calendar.getInstance()

        val dialog = DatePickerDialog(
            this,
            { _, year, month, day ->
                val selectedDate = "0$day/0${month + 1}/$year"

                val dateFormat = SimpleDateFormat("dd/MM/yyyy")
                val date = dateFormat.parse(selectedDate)
                selectedAgeTextView?.text = "$date"
                ageInMinutesTextView?.text = "${(System.currentTimeMillis() - date.time) / 60000}"

            },
            calender.get(Calendar.YEAR),
            calender.get(Calendar.MONTH),
            calender.get(Calendar.DAY_OF_MONTH)
        )

        dialog.datePicker.maxDate = System.currentTimeMillis()

        dialog.show()

    }
}