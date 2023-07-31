package com.example.thirtydaystheme.datasource

import com.example.thirtydaystheme.R
import com.example.thirtydaystheme.model.DaysModel

class DaysDataSource {
    fun daysDataSource():List<DaysModel>{
        return listOf(
            DaysModel(
                R.string.day1,
                R.string.day1_summary,
                R.drawable.day1,
                R.string.day1_desc
            ),
            DaysModel(
                R.string.day2,
                R.string.day2_summary,
                R.drawable.day2,
                R.string.day2_desc
            ),
            DaysModel(
                R.string.day3,
                R.string.day3_summary,
                R.drawable.day3,
                R.string.day3_desc
            ),
            DaysModel(
                R.string.day4,
                R.string.day4_summary,
                R.drawable.day4,
                R.string.day4_desc
            ),
            DaysModel(
                R.string.day5,
                R.string.day5_summary,
                R.drawable.day5,
                R.string.day5_desc
            ),
            DaysModel(
                R.string.day6,
                R.string.day6_summary,
                R.drawable.day6,
                R.string.day6_desc
            ),
            DaysModel(
                R.string.day7,
                R.string.day7_summary,
                R.drawable.day7,
                R.string.day7_desc
            ),
            DaysModel(
                R.string.day8,
                R.string.day8_summary,
                R.drawable.day8,
                R.string.day8_desc
            ),
            DaysModel(
                R.string.day9,
                R.string.day9_summary,
                R.drawable.day9,
                R.string.day9_desc
            ),
            DaysModel(
                R.string.day10,
                R.string.day10_summary,
                R.drawable.day10,
                R.string.day10_desc
            )
        )
    }
}