package com.ashimbekov.mymeals.data.models.user

enum class UserActivityLevel(val value: Double) {
    LITTLE(1.2),
    LIGHT(1.375),
    MODERATE(1.55),
    HARD(1.725),
    VERY_HARD(1.9)
}