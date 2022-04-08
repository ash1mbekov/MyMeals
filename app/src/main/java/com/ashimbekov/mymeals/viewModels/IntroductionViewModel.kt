package com.ashimbekov.mymeals.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ashimbekov.mymeals.data.models.Event
import com.ashimbekov.mymeals.data.models.prefs.SharedPrefsHelper
import com.ashimbekov.mymeals.data.models.user.UserGoal
import com.ashimbekov.mymeals.data.repositories.IntroductionRepository
import com.ashimbekov.mymeals.data.repositories.UserRepository
import kotlinx.coroutines.coroutineScope

class IntroductionViewModel (
    private val userRepository: UserRepository,
    private val introductionRepository: IntroductionRepository,
    private val spHelper: SharedPrefsHelper
):ViewModel() {

    val goal: LiveData<UserGoal> = introductionRepository.goal
    val applied: MutableLiveData<Boolean> = introductionRepository.applied

    private var _valuesInvalid = MutableLiveData<Event<Boolean>>()

    val valuesInvalid: LiveData<Event<Boolean>>
        get() = _valuesInvalid

    private val _progressBar = MutableLiveData<Event<Boolean>>()

    val progressBar: LiveData<Event<Boolean>>
        get() = _progressBar

    suspend fun saveUser() = coroutineScope {
        val user = introductionRepository.createUser()
        spHelper.saveIntroductionPassed()
        user?.let {
            userRepository.saveUser(it)
        }
    }


    private fun showInvalidToast(itemId: Boolean) {
        _valuesInvalid.value = Event(itemId)
    }

    fun showProgressBar(itemId: Boolean) {
        _progressBar.postValue(Event(itemId))
    }

    fun canUnblockButton(length: Int, length1: Int, notEmpty: Boolean): Boolean =
        introductionRepository.canUnblockButton(length, length1, notEmpty)

    fun areHeightWeightInvalid(text: String, text1: String): Boolean {
        val are = introductionRepository.areHeightWeightInvalid(text, text1)
        if (!are) {
            showInvalidToast(true)
        }
        return are
    }


    suspend fun ifUserExists() = userRepository.ifUserExists()


    fun chooseGoal(goal: UserGoal) = introductionRepository.chooseGoal(goal)

    fun setWeightValue(toString: String) = introductionRepository.setWeightValue(toString)

    fun setAgeValue(toString: String) = introductionRepository.setAgeValue(toString)

    fun setHeightValue(toString: String) = introductionRepository.setHeightValue(toString)

    fun setAppliedValue(b: Boolean) = introductionRepository.setAppliedValue(b)

    fun setActivityLevel(position: Int) = introductionRepository.setActivityLevel(position)

    fun setActivityChosen(b: Boolean) = introductionRepository.setActivityChosen(b)

    fun sexChosenValue(b: Boolean) = introductionRepository.sexChosenValue(b)

    fun sexValue(b: Boolean) = introductionRepository.sexValue(b)


}