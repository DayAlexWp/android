package com.wccnet.lifecycleawareproject

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.wccnet.lifecycleawareproject.ui.main.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class DemoObserver(): LifecycleObserver {
    private val myCoroutineScope = CoroutineScope(Dispatchers.Main)
    var MV = MainViewModel

    @RequiresApi(Build.VERSION_CODES.O)
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        MV.addLine("onCreate called")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        MV.addLine("onResume called")
        MV.addLine("**************")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        MV.addLine("onStart called")
    }
}