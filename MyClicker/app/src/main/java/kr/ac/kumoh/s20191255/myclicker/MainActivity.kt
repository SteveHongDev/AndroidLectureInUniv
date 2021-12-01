package kr.ac.kumoh.s20191255.myclicker

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import kr.ac.kumoh.s20191255.myclicker.databinding.ActivityMainBinding
import java.nio.channels.AsynchronousByteChannel
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: GameViewModel

    var level: Long = 0
        get() = viewModel.level

    var seed: Int = 0
        get() = viewModel.seed

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        connect()

        binding.btnLevelUp.setOnClickListener {
            viewModel.levelUp()

            setMoney()
            setLevelUp()
            binding.gameView.invalidate()
        }

        binding.btnSaveGame.setOnClickListener {
            save()
//            newGame()
        }
    }

    override fun onStop() {
        super.onStop()

        save()
    }

    fun connect() {
        Thread(Runnable {
            viewModel.connect()
            setMoney()
            setLevelUp()
        }).start()
    }

    fun save() {
        val task = object: AsyncTask<Unit, Unit, Unit>() {
            override fun doInBackground(vararg params: Unit?) {
                viewModel.save()
            }

            override fun onPostExecute(result: Unit?) {
                super.onPostExecute(result)
                Toast.makeText(getApplication(), "Game Saved", Toast.LENGTH_SHORT).show()
            }
        }
        task.execute(Unit)
    }

    fun newGame() {
        val task = object: AsyncTask<Unit, Unit, Unit>() {
            override fun doInBackground(vararg params: Unit?) {
                viewModel.newGame()
            }

            override fun onPostExecute(result: Unit?) {
                super.onPostExecute(result)

                setMoney()
                setLevelUp()
                binding.gameView.invalidate()

                Toast.makeText(getApplication(), "Game Deleted", Toast.LENGTH_SHORT).show()
            }
        }
        task.execute(Unit)
    }

    fun setMoney() {
        val f = DecimalFormat("$###,###")
        binding.textView.text = f.format(viewModel.money)
    }

    fun setLevelUp() {
        val cost = viewModel.levelUpCost(viewModel.level)
        val f = DecimalFormat("$###,###")
        val next = f.format(cost)
        binding.btnLevelUp.text = "[Current Level: ${viewModel.level}] Level Up (need $next)"
    }

    fun addMoney() {
        viewModel.addMoney()

        setMoney()
    }
}