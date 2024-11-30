package com.example.sharedviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    val _dataSet: MutableLiveData<String> = MutableLiveData()

    fun setData(data: String) {
        _dataSet.value = data
    }
}