package kr.ac.kumoh.s20191255.eventpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kr.ac.kumoh.s20191255.eventpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    inner class MyHandler : View.OnClickListener {
//        override fun onClick(v: View?) {
//            binding.textView.text = "Pushed Two!"
//            binding.textView.textSize = 50.toFloat()
//        }
//
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val h: MyHandler = MyHandler()
//        binding.button.setOnClickListener(h)

        binding.button.setOnClickListener {
            binding.textView.text = "Pushed Three!"
            binding.textView.textSize = 50.toFloat()
            Toast.makeText(this, "Pushed!", Toast.LENGTH_SHORT).show()
        }
    }

//    fun onButton(v: View) {
//        binding.textView.text = "Pushed!"
//        binding.textView.textSize = 50.toFloat()
//        Toast.makeText(this, "Pushed!", Toast.LENGTH_SHORT).show()
//    }

//    override fun onClick(v: View?) {
//        binding.textView.text = "Pushed One!"
//        binding.textView.textSize = 50.toFloat()
//        Toast.makeText(this, "Pushed!", Toast.LENGTH_SHORT).show()
//    }
}