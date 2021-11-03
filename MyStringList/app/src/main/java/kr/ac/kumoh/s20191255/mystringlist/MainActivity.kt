package kr.ac.kumoh.s20191255.mystringlist

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kr.ac.kumoh.s20191255.mystringlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val games = arrayOf(
        "Detroit: Become Human", "Hades", "Death Stranding", "Enter The Gungeon",
        "Detroit: Become Human", "Hades", "Death Stranding", "Enter The Gungeon",
        "Detroit: Become Human", "Hades", "Death Stranding", "Enter The Gungeon",
        "Detroit: Become Human", "Hades", "Death Stranding", "Enter The Gungeon",
        "Detroit: Become Human", "Hades", "Death Stranding", "Enter The Gungeon"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.list.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, games)
        binding.list.setOnItemClickListener { _, _, i, _ ->
            val uri = Uri.parse("https://store.steampowered.com/search/?term=" + games[i])
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }
}