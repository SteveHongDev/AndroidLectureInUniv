package com.example.myapplication7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            var n: Int
            n = Random.nextInt(1, 46)
            textLeft.text = n.toString()
            n = Random.nextInt(1, 46)
            textRight.text = n.toString()
//            text.text = "$n"
//            text.text = "" + n
        }
    }
}