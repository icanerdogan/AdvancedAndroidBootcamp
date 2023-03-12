package com.ibrahimcanerdogan.advancedandroidbootcamp.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.ibrahimcanerdogan.advancedandroidbootcamp.R

class DataBindingActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding)
        binding.person = getPerson()

        binding.buttonSend.setOnClickListener {
            displayGreeting()
        }
    }

    private fun displayGreeting() {
        binding.apply {
            textView.text = "Hello ${editText.text}"
        }
    }

    private fun getPerson() : Person {
        return Person(1, "Ibrahim Can Erdogan", "0(000)1112233")
    }
}