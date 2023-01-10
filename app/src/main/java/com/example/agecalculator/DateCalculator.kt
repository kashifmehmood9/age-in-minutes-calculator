package com.example.agecalculator

import java.text.SimpleDateFormat

class DateCalculator {
    fun calculateDate(day: Int, month: Int, year: Int): Pair<String, String> {
        val selectedDate = "0$day-0${month + 1}-$year"
        val dateFormat = SimpleDateFormat("dd-mm-yyyy")

        return Pair(
            selectedDate,
            "${(System.currentTimeMillis() - dateFormat.parse(selectedDate).time) / 60000}"
        )
    }
}