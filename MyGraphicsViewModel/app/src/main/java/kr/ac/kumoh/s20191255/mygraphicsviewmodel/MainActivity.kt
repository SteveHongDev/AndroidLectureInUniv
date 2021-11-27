package kr.ac.kumoh.s20191255.mygraphicsviewmodel

import android.graphics.PointF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kr.ac.kumoh.s20191255.mygraphicsviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ListViewModel
//    private lateinit var view: GraphicView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
//        view = GraphicView(this)
//        setContentView(view)
    }

    fun addPosition(x: Float, y: Float) {
        viewModel.add(x, y)
    }

    fun getPositionList(): ArrayList<PointF> {
        return viewModel.list
    }
}