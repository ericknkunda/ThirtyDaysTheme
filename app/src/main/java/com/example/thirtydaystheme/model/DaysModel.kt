package com.example.thirtydaystheme.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class DaysModel(
    @StringRes val DayId:Int,
    @StringRes val DaySummary:Int,
    @DrawableRes val DayImg:Int,
    @StringRes val DayDesc:Int
)