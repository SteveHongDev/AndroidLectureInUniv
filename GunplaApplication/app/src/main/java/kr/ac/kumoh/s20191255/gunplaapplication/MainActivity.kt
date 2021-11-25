package kr.ac.kumoh.s20191255.gunplaapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kr.ac.kumoh.s20191255.gunplaapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var view: ActivityMainBinding

    private val model: GunplaViewModel by viewModels()
    private lateinit var adapter: GunplaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)

        adapter = GunplaAdapter(model) { mechanic -> adapterOnClick(mechanic) }

        view.list.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            setHasFixedSize(true)
            itemAnimator = DefaultItemAnimator()
            adapter = this@MainActivity.adapter
        }

        model.list.observe(this, {
            adapter.notifyDataSetChanged()
        })

        model.requestMechanic()
    }

    private fun adapterOnClick(mechanic: GunplaViewModel.Mechanic): Unit {
        val uri = Uri.parse("https://www.youtube.com/results?search_query=${mechanic.model}")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
}