package kr.ac.kumoh.s20191255.midexam2021

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ScrollView
import android.widget.Toast
import kr.ac.kumoh.s20191255.midexam2021.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var view: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)

        view.itemNetflix.setOnClickListener(this)
        view.itemInstagram.setOnClickListener(this)
        view.itemTictok.setOnClickListener(this)
        view.itemYoutube.setOnClickListener(this)
        view.itemCall.setOnClickListener(this)
        view.itemDiscord.setOnClickListener(this)
        view.itemLinkedin.setOnClickListener(this)
        view.itemMessenger.setOnClickListener(this)
        view.itemSpotify.setOnClickListener(this)
        view.itemTwitter.setOnClickListener(this)
        view.btnSearch.setOnClickListener(this)

        view.btnUp.setOnClickListener {
            view.scroll.fullScroll(ScrollView.FOCUS_UP)
        }
    }

    override fun onClick(v: View?) {
        var text = "default"
        var uriString = "localhost"
        when (v?.id) {
            view.itemNetflix.id -> {
                text = "Netflix"
                uriString = "http://www.netflix.com"
            }
            view.itemInstagram.id -> {
                text = "Instagram"
                uriString = "http://www.instagram.com"
            }
            view.itemTictok.id -> {
                text = "Tictok"
                uriString = "http://www.tiktok.com"
            }
            view.itemYoutube.id -> {
                text = "Youtube"
                uriString = "http://www.youtube.com"
            }
            view.itemCall.id -> {
                text = "Call"
                uriString = "tel:"
            }
            view.itemDiscord.id -> {
                text = "Discord"
                uriString = "http://www.discord.com"
            }
            view.itemLinkedin.id -> {
                text = "LinkedIn"
                uriString = "http://www.linkedin.com"
            }
            view.itemMessenger.id -> {
                text = "Messenger"
                uriString = "sms:"
            }
            view.itemSpotify.id -> {
                text = "Spotify"
                uriString = "http://www.spotify.com"
            }
            view.itemTwitter.id -> {
                text = "Twitter"
                uriString = "http://www.twitter.com"
            }
            view.btnSearch.id -> {
                text = view.editText.text.toString()
                uriString = "http://www.google.com/search?q=" + text
            }
            null -> return
        }
        Toast.makeText(applicationContext, text, Toast.LENGTH_LONG).show()
        val uri = Uri.parse(uriString)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
}