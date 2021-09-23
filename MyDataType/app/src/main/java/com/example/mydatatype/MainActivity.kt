package com.example.mydatatype

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        my_button.setOnClickListener {
            count++
            my_text.text = count.toString()
//
//            val pi = 3.14
//            val i = pi as Double
//            my_text.text = i.toString()
        }

        my_button2.setOnClickListener {
            if (--count < 0)
                count = 0
            my_text.text = count.toString()
        }

        my_button_reset.setOnClickListener {
            count = 0
            my_text.text = count.toString()
        }

        my_button_set.setOnClickListener {
            count = my_edit.text.toString().toIntOrNull() ?: count
            my_text.text = count.toString()
        }
    }
}