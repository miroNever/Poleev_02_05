package com.example.exampoleev

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView

@Suppress("DEPRECATION")
class MainScrean : AppCompatActivity() {

    private lateinit var movieImages: List<Int>
    private lateinit var movieTitles: List<String>
    private lateinit var viewPagerMovie: ViewPager
    private lateinit var tvMovieTitle: TextView
    private lateinit var bottomMenu: BottomNavigationView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        movieImages = listOf(R.drawable.avengers, R.drawable.capitan_marvel, R.drawable.iron_man)
        movieTitles = listOf("Мстители", "Капитан Марвел", "Железный человек")

        viewPagerMovie = findViewById(R.id.viewPagerMovie)
        tvMovieTitle = findViewById(R.id.tvmovie_title)
        bottomMenu = findViewById(R.id.bottom_menu_id)

        viewPagerMovie.adapter = MovieAdapter(this, movieImages, movieTitles)
        viewPagerMovie.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                tvMovieTitle.text = movieTitles[position]
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

        bottomMenu.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_selection -> {
                    val resultTitle = tvMovieTitle.text.toString()
                    val intent = Intent(this, ThirdActivity::class.java).apply {
                        putExtra("movie_title", resultTitle)
                        putExtra("movieImage", movieImages[viewPagerMovie.currentItem])
                    }
                    startActivity(intent)
                }
            }
            true
        }
    }
}