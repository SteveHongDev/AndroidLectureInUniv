package kr.ac.kumoh.s20191255.simplelist

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kr.ac.kumoh.s20191255.simplelist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val mArray = arrayOf("Instagram", "Twitter", "Tiktok", "Linkedin", "Google", "Notion",
        "Roam Research", "Obsidian", "Dynalist", "Evernote", "Google Keep", "Asana", "Amplenote", "Bear", "Notability")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listView.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mArray)
        binding.listView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, mArray[position], Toast.LENGTH_SHORT).show()

            val uri = Uri.parse("http://www.google.com/search?q=" + mArray[position])
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }
}