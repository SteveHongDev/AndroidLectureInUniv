package kr.ac.kumoh.s20191255.midexam2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ScrollView
import android.widget.Toast
import kr.ac.kumoh.s20191255.midexam2021.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var view: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)

        view.itemNetflix.setOnClickListener {
            Toast.makeText(applicationContext, "Netflix", Toast.LENGTH_LONG).show()
        }
        // ...
        view.button.setOnClickListener {
            view.scroll.fullScroll(ScrollView.FOCUS_UP)
        }
    }
}