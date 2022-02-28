package com.ferdifir.netplix.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.ferdifir.netplix.MyApplication
import com.ferdifir.netplix.R
import com.ferdifir.netplix.core.domain.model.Sport
import com.ferdifir.netplix.databinding.ActivityDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    //private lateinit var viewModel: DetailViewModel

    //@Inject
    //lateinit var factory: ViewModelFactory

    private val detailViewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        //(application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        //val factory = ViewModelFactory.getInstance(this)
        //viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val detailSport = intent.getParcelableExtra<Sport>(EXTRA_DATA)
        showDetailSport(detailSport)
    }

    private fun showDetailSport(sport: Sport?) {
        sport?.let {
            binding.toolbarLayout.title = sport.strSport
            binding.content.text = sport.strSportDescription
            Glide.with(this)
                .load(sport.strSportThumb)
                .into(binding.ivThumbnail)

            var statusFavorite = sport.strLiked
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailViewModel.setFavoriteSport(sport, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_border))
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}