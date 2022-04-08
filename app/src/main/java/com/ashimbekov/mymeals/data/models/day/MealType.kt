package com.ashimbekov.mymeals.data.models.day

enum class MealType constructor(var code: Int = 0) {
    BREAKFAST(1),
    LUNCH(2),
    SNACK(3),
    DINNER(4);

    override fun toString(): String {
        return when (this) {
            BREAKFAST -> {
                "Breakfast"
            }
            LUNCH -> {
                "Lunch"
            }
            SNACK -> {
                "Snack"
            }
            DINNER -> {
                "Dinner"
            }
        }
    }
}