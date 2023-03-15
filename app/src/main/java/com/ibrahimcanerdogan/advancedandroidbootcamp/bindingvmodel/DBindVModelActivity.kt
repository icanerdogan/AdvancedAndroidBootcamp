package com.ibrahimcanerdogan.advancedandroidbootcamp.bindingvmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ibrahimcanerdogan.advancedandroidbootcamp.R
import com.ibrahimcanerdogan.advancedandroidbootcamp.databinding.ActivityDbindVmodelBinding

class DBindVModelActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDbindVmodelBinding
    private lateinit var viewModel: DBindViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dbind_vmodel)
        viewModel = ViewModelProvider(this)[DBindViewModel::class.java]

        // bind data variable name
        binding.viewmodel = viewModel

        // bind observe text in TextView
        binding.lifecycleOwner = this
/*        viewModel.countData.observe(this, Observer {
            binding.textView.text = it.toString()
        })*/

    }
}