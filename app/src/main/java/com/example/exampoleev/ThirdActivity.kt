package com.example.exampoleev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ThirdActivity : AppCompatActivity() {
    private lateinit var tvResultTitle: TextView
    private lateinit var ivResultImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var title = intent.getStringExtra("movie_title")
        var image = intent.getIntExtra("movieImage", 0)

        tvResultTitle.text = title
        ivResultImage.setImageResource(image)
    }
}