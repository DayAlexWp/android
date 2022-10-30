package com.wccnet.addnamesavedata2.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var result: MutableLiveData<String> = MutableLiveData()

    public fun addName(newName: String) { //setter
        result.value = result.value + newName + "\n"
    }

    public fun getNames(): MutableLiveData<String> { return result } //getter
}