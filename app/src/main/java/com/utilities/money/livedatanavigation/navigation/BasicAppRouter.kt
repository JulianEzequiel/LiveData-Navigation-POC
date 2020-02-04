package com.utilities.money.livedatanavigation.navigation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.utilities.money.livedatanavigation.navigation.event.SingleLiveEvent

class BasicAppRouter: ViewModel() {

    private val _actionBarTitle = SingleLiveEvent<String>()
    val actionBarTitle : LiveData<String> get() = _actionBarTitle


    fun changeActionBarTitle(message: String) {
        _actionBarTitle.value = message
    }

}