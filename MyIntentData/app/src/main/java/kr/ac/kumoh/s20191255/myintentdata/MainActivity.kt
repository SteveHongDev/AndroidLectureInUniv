package kr.ac.kumoh.s20191255.myintentdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kr.ac.kumoh.s20191255.myintentdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var view: ActivityMainBinding

    companion object {
        const val keyName = "name"
        const val requestBackground = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)

        view.btnSky.setOnClickListener(this)

        view.btnOcean.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, BackgroundActivity::class.java)
        when (v?.id) {
            view.btnSky.id -> intent.putExtra(keyName, "sky")
            view.btnOcean.id -> intent.putExtra(keyName, "ocean")
            null -> return
        }

//        startActivity(intent)
        startActivityForResult(intent, requestBackground)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            when (requestCode) {
                requestBackground -> {
                    view.textView.text = data?.getStringExtra(BackgroundActivity.result)
                }
            }
        }
    }
}