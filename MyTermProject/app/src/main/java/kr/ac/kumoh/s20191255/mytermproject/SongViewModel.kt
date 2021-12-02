package kr.ac.kumoh.s20191255.mytermproject

import android.app.Application
import android.graphics.Bitmap
import android.util.LruCache
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.ImageLoader
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject
import java.net.URLEncoder

class SongViewModel(application: Application): AndroidViewModel(application) {
    data class Song(var id: Int, var title: String, var singer: String, var image: String)

    val list = MutableLiveData<ArrayList<Song>>()
    val imageLoader: ImageLoader
    private val song = ArrayList<Song>()

    companion object {
        const val QUEUE_TAG = "SongVolleyRequest"
        const val SERVER_URL = "https://expresssongdatabase-ugazr.run.goorm.io/"
    }

    private var queue: RequestQueue

    init {
        list.value = song
        queue = Volley.newRequestQueue(application)

        imageLoader = ImageLoader(queue,
            object : ImageLoader.ImageCache {
                private val cache = LruCache<String, Bitmap>(100)
                override fun getBitmap(url: String?): Bitmap? {
                    return cache.get(url)
                }

                override fun putBitmap(url: String?, bitmap: Bitmap?) {
                    cache.put(url, bitmap)
                }
            }
        )
    }

    fun getImageUrl(i: Int): String = "$SERVER_URL/image/" + URLEncoder.encode(song[i].image, "utf-8")

    fun requestSong() {
        // NOTE: 서버 주소는 본인의 서버 IP 사용할 것
        val url = SERVER_URL

        val request = JsonArrayRequest(
            Request.Method.GET,
            url,
            null,
            {
//                Toast.makeText(getApplication(), it.toString(), Toast.LENGTH_LONG).show()
                song.clear()
                parseJson(it)
                list.value = song
            },
            {
                Toast.makeText(getApplication(), it.toString(), Toast.LENGTH_LONG).show()
            }
        )

        request.tag = QUEUE_TAG
        queue.add(request)
    }

    fun getSong(i: Int) = song[i]
    fun getSize() = song.size

    override fun onCleared() {
        super.onCleared()
        queue.cancelAll(QUEUE_TAG)
    }

    private fun parseJson(items: JSONArray) {
        for (i in 0 until items.length()) {
            val item: JSONObject = items[i] as JSONObject
            val id = item.getInt("id")
            val title = item.getString("title")
            val singer = item.getString("singer")
            val image = item.getString("image")

            song.add(Song(id, title, singer, image))
        }
    }

}