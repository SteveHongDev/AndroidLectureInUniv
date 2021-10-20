package kr.ac.kumoh.s20191255.myintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ac.kumoh.s20191255.myintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var view: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)

        view.btnExplicitIntent.setOnClickListener {
            val intent = Intent(this, ImageActivity::class.java)
            startActivity(intent)
        }

        view.btnImplicitIntent.setOnClickListener {
            val uri = Uri.parse("http://www.github.com/" + view.editText.text.toString()) // urn + url = uri
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }
}