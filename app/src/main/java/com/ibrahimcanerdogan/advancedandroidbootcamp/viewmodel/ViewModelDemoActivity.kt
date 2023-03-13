package com.ibrahimcanerdogan.advancedandroidbootcamp.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ibrahimcanerdogan.advancedandroidbootcamp.R
import com.ibrahimcanerdogan.advancedandroidbootcamp.databinding.ActivityViewModelBinding

class ViewModelDemoActivity : AppCompatActivity() {
    // https://dev.to/vtsen/recommended-ways-to-create-viewmodel-or-androidviewmodel-5e7k

    private lateinit var binding : ActivityViewModelBinding
    private val viewModelFactory by lazy { DemoViewModelFactory(100) }

/*    We can not construct a ViewModel instance on our own.
    We need to use the ViewModelProvider utility provided by Android to create instances of ViewModels.*/

    // private val viewModel: DemoViewModel by viewModels()

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[DemoViewModel::class.java]
    }

    private val viewModel1: DemoViewModel by viewModels {
        DemoViewModelFactory(100)
    }

    private val viewModel2: DemoViewModel by lazy {
        val factory = DemoViewModelFactory(100)

        ViewModelProvider(this, factory)[DemoViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_model)

        binding.textView1.text = viewModel.getCurrentCount().toString()

        binding.button1.setOnClickListener {
            binding.textView1.text = viewModel.getUpdatedCount().toString()
        }

        binding.textView2.text = viewModel.getTotalValue().toString()

        binding.button2.setOnClickListener {
            binding.textView2.text = viewModel.addValueTotal(
                binding.editText.text.toString().toInt()
            ).toString()
        }
    }
}