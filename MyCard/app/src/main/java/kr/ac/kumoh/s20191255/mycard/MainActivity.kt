package kr.ac.kumoh.s20191255.mycard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.ac.kumoh.s20191255.mycard.databinding.ActivityMainBinding
import java.util.*
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding // lateinit: 나중에 초기화 할게! 라는 뜻

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //binding.card1.setImageResource(R.drawable.c_2_of_hearts)
//        val c = Random.nextInt(52)
//        Log.i("Test", "$c : ${getCardName(c)}")
//
//        val res = resources.getIdentifier(
//            getCardName(c),
//            "drawable",
//            packageName
//        )
//
//        binding.card1.setImageResource(res)
        binding.btnDeal.setOnClickListener {

            val c = IntArray(5)
            val res = IntArray(5)

            //for (i in 0..4)
            //for (i in 0 until 5)
            //for (i in 0 until c.size)
            for (i in c.indices) {
                c[i] = Random.nextInt(52)

                Log.i(
                    "Test", "${c[i]} : " +
                            "${getCardName(c[i])}"
                )

                res[i] = resources.getIdentifier(
                    getCardName(c[i]),
                    "drawable",
                    packageName
                )
            }


            binding.card1.setImageResource(res[0])
            binding.card2.setImageResource(res[1])
            binding.card3.setImageResource(res[2])
            binding.card4.setImageResource(res[3])
            binding.card5.setImageResource(res[4])
        }
    }

    private fun getCardName(c: Int) : String {
        val shape = when (c / 13) {
            0 -> "spades"
            1 -> "diamonds"
            2 -> "hearts"
            3 -> "clubs"
            else -> "error"
        }

        val number = when (c % 13) {
            0 -> "ace"
            in 1..9 -> (c % 13 + 1).toString()
            10 -> "jack"
            11 -> "queen"
            12 -> "king"
            else -> "error"
        }

        return "c_${number}_of_${shape}"
    }
}