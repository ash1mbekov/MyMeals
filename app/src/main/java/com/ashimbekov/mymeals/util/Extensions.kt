package com.ashimbekov.mymeals.util

import java.math.BigDecimal
import java.math.RoundingMode

// round float to decimals
fun Float.round(decimals: Int): Float {
    return BigDecimal(this.toDouble()).setScale(decimals, RoundingMode.HALF_EVEN).toFloat()
}