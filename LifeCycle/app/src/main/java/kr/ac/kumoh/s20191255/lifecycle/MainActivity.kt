package kr.ac.kumoh.s20191255.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.ac.kumoh.s20191255.lifecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.i("Lifecycle", "onCreate()")
    }

    override fun onStart() {
        super.onStart()
        Log.i("Lifecycle", "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Lifecycle", "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Lifecycle", "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Lifecycle", "onStop()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Lifecycle", "onRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Lifecycle", "onDestroy()")
    }
}