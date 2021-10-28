package kr.ac.kumoh.s20191255.myadapterandlist

import android.R
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import kr.ac.kumoh.s20191255.myadapterandlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    data class App (var name: String, var category: String)

    var mArray = ArrayList<App>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mArray.add(App("Instagram", "Social Network"))
        mArray.add(App("Notion", "Note-taking"))
        mArray.add(App("Todoist", "Productivity"))
        mArray.add(App("Roam Research", "Zettelkasten"))
        mArray.add(App("Twitter", "Social Network"))
        mArray.add(App("Apple Music", "Music"))
        mArray.add(App("Spark", "Mail management"))
        mArray.add(App("Kindle", "E-Book"))
        mArray.add(App("Instagram", "Social Network"))
        mArray.add(App("Notion", "Note-taking"))
        mArray.add(App("Todoist", "Productivity"))
        mArray.add(App("Roam Research", "Zettelkasten"))
        mArray.add(App("Twitter", "Social Network"))
        mArray.add(App("Apple Music", "Music"))
        mArray.add(App("Spark", "Mail management"))
        mArray.add(App("Kindle", "E-Book"))
        mArray.add(App("Instagram", "Social Network"))
        mArray.add(App("Notion", "Note-taking"))
        mArray.add(App("Todoist", "Productivity"))
        mArray.add(App("Roam Research", "Zettelkasten"))
        mArray.add(App("Twitter", "Social Network"))
        mArray.add(App("Apple Music", "Music"))
        mArray.add(App("Spark", "Mail management"))
        mArray.add(App("Kindle", "E-Book"))

//        binding.listView.adapter = ArrayAdapter<String>(this, R.layout.simple_list_item_1, mArray)

        binding.listView.adapter = AppAdapter_Array(this, android.R.layout.simple_list_item_1, mArray)
//        binding.listView.adapter = AppAdapter(this)

        binding.listView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, mArray[position].category, Toast.LENGTH_SHORT).show()

            val uri = Uri.parse("http://www.google.com/search?q=" + mArray[position])
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }

    private class AppViewHolder {
        lateinit var txName: TextView
        lateinit var txCategory: TextView
    }

    inner class AppAdapter(context: Context) : BaseAdapter() {
        private var mInflater = LayoutInflater.from(context)
        override fun getCount(): Int {
            return mArray.size
        }

        override fun getItem(position: Int): Any {
            return mArray[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view: View
            val viewHolder: AppViewHolder

            if (convertView == null) {
                view = mInflater.inflate(android.R.layout.simple_list_item_2, parent, false)
                viewHolder = AppViewHolder()
                viewHolder.txName = view.findViewById(android.R.id.text1)
                viewHolder.txCategory = view.findViewById(android.R.id.text2)

                view.tag = viewHolder
            } else {
                view = convertView
                viewHolder = view.tag as AppViewHolder
            }

            viewHolder.txName.text = mArray[position].name
            viewHolder.txCategory.text = mArray[position].category
            return view
        }
    }

    inner class AppAdapter_Array(context: Context, resource: Int, objects: MutableList<App>) :
        ArrayAdapter<App>(context, resource, objects) {
        private var mInflater = LayoutInflater.from(context)

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view: View
            val viewHolder: AppViewHolder

            if (convertView == null) {
                view = mInflater.inflate(android.R.layout.simple_list_item_2, parent, false)
                viewHolder = AppViewHolder()
                viewHolder.txName = view.findViewById(android.R.id.text1)
                viewHolder.txCategory = view.findViewById(android.R.id.text2)

                view.tag = viewHolder
            } else {
                view = convertView
                viewHolder = view.tag as AppViewHolder
            }

            viewHolder.txName.text = getItem(position)?.name
            viewHolder.txCategory.text = getItem(position)?.category
            return view
        }
    }
}