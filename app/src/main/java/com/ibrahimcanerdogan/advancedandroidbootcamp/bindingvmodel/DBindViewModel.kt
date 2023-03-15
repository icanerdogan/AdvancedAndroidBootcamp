package com.ibrahimcanerdogan.advancedandroidbootcamp.bindingvmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DBindViewModel : ViewModel() {
    private val count = MutableLiveData<Int>()
    val countData : LiveData<Int>
        get() = count

    private val userName = MutableLiveData<String>()
    val userNameData : LiveData<String>
        get() = userName

    private val total = MutableLiveData<Int>()
    val totalData : LiveData<Int>
        get() = total

    private val inputText = MutableLiveData<String>()
    val inputTextData : LiveData<String>
        get() = inputText
    init {
        count.value = 0
        userName.value = "Ibrahim"
        total.value = 0
        inputText.value = ""
    }

    fun addCount() {
        count.value = count.value?.plus(1)
    }

    fun totalValue() {
        val input = inputText.value?.toInt()
        total.value = total.value?.plus(input!!)
    }
}