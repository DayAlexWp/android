package com.wccnet.addnamesavedata.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var namesList = ArrayList<String>() //stores user inputted list of names

    public fun addName(newName: String) { namesList.add(newName) } //setter

    public fun getNames(): ArrayList<String> { return namesList } //getter
}