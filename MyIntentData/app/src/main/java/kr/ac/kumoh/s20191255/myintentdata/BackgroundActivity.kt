package kr.ac.kumoh.s20191255.myintentdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ac.kumoh.s20191255.myintentdata.databinding.ActivityBackgroundBinding
import kr.ac.kumoh.s20191255.myintentdata.databinding.ActivityMainBinding

class BackgroundActivity : AppCompatActivity() {
    private lateinit var view: ActivityBackgroundBinding

    companion object {
        const val result = "result"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityBackgroundBinding.inflate(layoutInflater)
        setContentView(view.root)

        view.editText.setText(intent.getStringExtra(MainActivity.keyName))

        when (intent.getStringExtra(MainActivity.keyName)) {
            "sky" -> view.imageView.setImageResource(R.drawable.sky)
            "ocean" -> view.imageView.setImageResource(R.drawable.ocean)
        }

        view.btnApply.setOnClickListener {
            val result = Intent()
            result.putExtra(BackgroundActivity.result, view.editText.text.toString())
            setResult(RESULT_OK, result)
            finish()
        }
    }
}