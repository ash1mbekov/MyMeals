package com.ashimbekov.mymeals.data.interfaces

interface UserDeleteCallback {
    fun onDeletionSuccess()
    fun onDeletionError()
    fun reauthRequired()
}