package com.ibrahimcanerdogan.advancedandroidbootcamp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DemoViewModelFactory(private val  startingTotal : Int) : ViewModelProvider.Factory {

/*    ViewModelProvider can only instantiate ViewModels with no arg constructors.

    So, if the ViewModel has constructor parameters(arguments) , ViewModelProvider need a little extra support to create instances of it.

    We provide that extra support by creating a Factory class and passing its instance to the ViewModelProvider.*/

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DemoViewModel::class.java)) {
            return DemoViewModel(startingTotal) as T
        }
        throw java.lang.IllegalArgumentException("Unknown ViewModel Class")
    }
}