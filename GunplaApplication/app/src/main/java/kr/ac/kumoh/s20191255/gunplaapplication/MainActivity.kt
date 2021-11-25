package kr.ac.kumoh.s20191255.gunplaapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kr.ac.kumoh.s20191255.gunplaapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var view: ActivityMainBinding

    companion object {
        const val QUEUE_TAG = "VolleyRequest"
    }

    private lateinit var mQueue: RequestQueue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)

        mQueue = VolleyRequest.getInstance(this.applicationContext).requestQueue

        requestMechanic()
    }

    override fun onStop() {
        super.onStop()
        mQueue.cancelAll(QUEUE_TAG)
    }

    private fun requestMechanic() {
        val url = "https://expressforvolley-hcxlq.run.goorm.io/gunpladb/mechanic/"

        val request = JsonArrayRequest(
            Request.Method.GET,
            url,
            null,
            {
                view.result.text = it.toString()
            },
            {
                Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
                view.result.text = it.toString()
            }
        )

        request.tag = QUEUE_TAG
        mQueue.add(request)
    }
}