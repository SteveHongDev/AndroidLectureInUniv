package kr.ac.kumoh.s20191255.mycrawler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kr.ac.kumoh.s20191255.mycrawler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var view: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)

        val queue = Volley.newRequestQueue(this)

        val url = "https://github.com/SteveHongDev"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                val ogTitle = "\"og:title\""
                val ogDesc = "\"og:description\""
                val ogImage = "\"og:image\""

                val resultTitle = findContent(response, ogTitle, 0)
                val resultDesc = findContent(response, ogDesc, 0)
                val resultImage = findContent(response, ogImage, 0)
                val text = "${resultTitle}\n" + "${resultDesc}"

                view.textView.text = text
                view.webView.loadUrl(resultImage)
            },
            {
                view.textView.text = "Error: $it"
            }
        )

        queue.add(stringRequest)
    }

    fun findContent(target: String, meta: String, startIndex: Int): String {
        val content = "content=\""
        val close = "\" />"
        var start = target.indexOf(meta)
        start = target.indexOf(content, start)
        val end = target.indexOf(close, start)

        return target.substring(start + content.length until end)
    }
}