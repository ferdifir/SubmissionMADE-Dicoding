package com.ferdifir.netplix.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ferdifir.netplix.MyApplication
import com.ferdifir.netplix.core.data.Resource
import com.ferdifir.netplix.core.ui.SportsAdapter
import com.ferdifir.netplix.databinding.ActivityMainBinding
import com.ferdifir.netplix.ui.detail.DetailActivity
import com.ferdifir.netplix.ui.favorite.FavoriteActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //private lateinit var viewModel: HomeViewModel

    //@Inject
    //lateinit var factory: ViewModelFactory

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        //(application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val v = binding.root
        setContentView(v)

        binding.fabFavorite.setOnClickListener {
            val intent = Intent(this, FavoriteActivity::class.java)
            startActivity(intent)
        }

        val sportAdapter = SportsAdapter()
        sportAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        //val factory = ViewModelFactory.getInstance(this)
        //viewModel = ViewModelProvider(this, factory)[HomeViewModel::class.java]

        viewModel.sport.observe(this) { sport ->
            if (sport != null) {
                when (sport) {
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        sportAdapter.setData(sport.data)
                    }
                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                    }
                }
            }
        }

        with(binding.rvSports) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = sportAdapter
        }
    }
}