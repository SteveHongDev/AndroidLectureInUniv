package kr.ac.kumoh.s20191255.mysonglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kr.ac.kumoh.s20191255.mysonglist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var model: SongViewModel
    private lateinit var view: ActivityMainBinding
    private val mAdapter = SongAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)

        model = ViewModelProvider(this).get(SongViewModel::class.java)

        view.list.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            setHasFixedSize(true)
            itemAnimator = DefaultItemAnimator()
            adapter = mAdapter
        }

        model.list.observe(this, Observer<ArrayList<SongViewModel.Song>> {
            mAdapter.notifyDataSetChanged()
        })

        model.requestSong()
    }

    inner class SongAdapter: RecyclerView.Adapter<SongAdapter.ViewHolder>() {
        inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            val txTitle: TextView = itemView.findViewById(android.R.id.text1)
            val txSinger: TextView = itemView.findViewById(android.R.id.text2)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = layoutInflater.inflate(android.R.layout.simple_list_item_2, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.txTitle.text = model.getSong(position).title
            holder.txSinger.text = model.getSong(position).singer
        }

        override fun getItemCount(): Int {
            return model.getSize()
        }
    }
}