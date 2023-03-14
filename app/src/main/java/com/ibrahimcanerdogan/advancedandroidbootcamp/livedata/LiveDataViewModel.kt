package com.ibrahimcanerdogan.advancedandroidbootcamp.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataViewModel(startingTotal : Int, private val increaseAmount : Int = 1) : ViewModel() {

    // We usually define LiveData, inside ViewModel classes.
    // Also, supporting libraries like Room and Retrofit allows us to get data directly in LiveData format.

    // Data in LiveData object are only readable not editable.
    // A MutableLiveData object allows us to change/update its data
    // MutableLiveData is a subclass of LiveData class.
    private var total = MutableLiveData<Int>()
    val totalData : LiveData<Int>
        get() = total

    private var count = MutableLiveData<Int>()
    val countData : LiveData<Int>
        get() = count

    init {
        total.value = startingTotal
        count.value = 0
    }

    fun addCount() {
        count.value = count.value?.plus(increaseAmount)
    }

    fun addValueTotal(value : Int) {
        total.value = total.value?.plus(value)
    }
}