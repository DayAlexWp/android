package com.wccnet.lifecycleawareproject.ui.main

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalDateTime
import java.util.*

class MainViewModel : ViewModel() {
    companion object {
        private var event: MutableLiveData<String> = MutableLiveData()

        @RequiresApi(Build.VERSION_CODES.O)
        fun addLine(newLine: String) {
            event.value = event.value + "\n" + newLine

            if (!newLine.contains("*")) {
                event.value = event.value + " on " + LocalDateTime.now()
            }
        }
    }

    fun getEvents(): MutableLiveData<String> {
        return event
    }
}