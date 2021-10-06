package kr.ac.kumoh.s20191255.myimages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import kr.ac.kumoh.s20191255.myimages.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val images = arrayOf(R.drawable.c_2_of_clubs,
        R.drawable.c_2_of_diamonds,
        R.drawable.c_2_of_hearts,
        R.drawable.c_2_of_spades,
        R.drawable.c_red_joker)
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView.setOnClickListener {
//            if (count < images.size - 1) {
//                count += 1
//            } else {
//                count = 0
//            }
            count = ++count % images.size
            val d = ResourcesCompat.getDrawable(resources, images[count], null)
            if (d != null)
                binding.imageView.setImageDrawable(d)
        }

    }
}