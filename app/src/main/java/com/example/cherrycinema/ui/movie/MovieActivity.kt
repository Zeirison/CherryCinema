package com.example.cherrycinema.ui.movie

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.example.cherrycinema.R
import com.example.cherrycinema.utils.API_IMAGES_URL
import kotlinx.android.parcel.Parcelize

class MovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        val options = intent.getParcelableExtra<MovieOptions>(EXTRA_MOVIE_OPTIONS)
        setupView(options)
    }

    private fun setupView(options: MovieOptions) {

        val posterUrl = API_IMAGES_URL + options.poster_path
        val posterView = findViewById<ImageView>(R.id.poster)
        Glide.with(this).load(posterUrl).into(posterView)

        val toolbar = findViewById<Toolbar>(R.id.animToolbar)
        toolbar.title = options.title
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val ratingView = findViewById<TextView>(R.id.rating)
        ratingView.text = getString(R.string.rating, options.rating)

        val overviewView = findViewById<TextView>(R.id.overview)
        overviewView.text = options.overview
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(0, 0)
    }

    companion object {
        fun startActivity(context: Context, options: MovieOptions) {
            val intent = Intent(context, MovieActivity::class.java)
            intent.putExtra(EXTRA_MOVIE_OPTIONS, options)
            context.startActivity(intent)
        }

        private const val EXTRA_MOVIE_OPTIONS = "EXTRA_MOVIE_OPTIONS"
    }

    @Parcelize
    data class MovieOptions(
        var title: String,
        var overview: String,
        var poster_path: String,
        var rating: String
    ) :
        Parcelable

}