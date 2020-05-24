package com.example.architecturecomponentexample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModal : ViewModel() {

    /**
     * TAG to track the class name
     */
    private val TAG: String? = this.javaClass.simpleName

    private var tapCount = 0

    private val _tapCount = MutableLiveData("$tapCount time clicked")

    /**
     * Public view of tap live data.
     */
    val taps: LiveData<String> get() = _tapCount


    /**
     * click event trigger on activity button click which increase counter by one and post value to
     * live data variable tapCount.
     */
    fun updateButtonClickNumbers() {
        tapCount++
        _tapCount.postValue("$tapCount time clicked")
    }


    /**
     * onCleared() called when the Scope of ViewModal is destroyed.
     */

    override fun onCleared() {
        super.onCleared()
        Log.i(TAG, "onCleared called in $TAG")
    }
}