package com.ibrahimcanerdogan.advancedandroidbootcamp.viewmodel

import androidx.lifecycle.ViewModel

class DemoViewModel(startingValue : Int) : ViewModel() {

    private var count = 0
    private var total = 0

    init {
        count = startingValue
    }

    fun getCurrentCount() : Int {
        return count
    }

    fun getUpdatedCount() : Int {
        return ++count
    }

    fun getTotalValue() : Int {
        return total
    }

    fun addValueTotal(value : Int) : Int {
        total += value
        return total
    }
}