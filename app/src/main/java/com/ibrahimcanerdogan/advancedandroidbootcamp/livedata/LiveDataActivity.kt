package com.ibrahimcanerdogan.advancedandroidbootcamp.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ibrahimcanerdogan.advancedandroidbootcamp.databinding.ActivityLiveDataBinding

class LiveDataActivity : AppCompatActivity() {
    // Android LiveData is a lifecycle-aware, observable data holder class.
    private val binding by lazy { ActivityLiveDataBinding.inflate(layoutInflater) }
    private val viewModel = LiveDataViewModel(500, 5)
    // A lifecycle aware observable data holder class.
    // LiveData only updates observes in an active lifecycle state. Activity, Fragment and Services
    // LiveData automatically updates the UI when app data changes.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.totalData.observe(this, Observer {
            binding.textView.text =  it.toString()
        })

        binding.button.setOnClickListener {
            viewModel.addValueTotal(binding.editText.text.toString().toInt())
        }

        viewModel.countData.observe(this, Observer {
            binding.textView1.text = it.toString()
        })

        binding.button1.setOnClickListener {
            viewModel.addCount()
        }
    }
}