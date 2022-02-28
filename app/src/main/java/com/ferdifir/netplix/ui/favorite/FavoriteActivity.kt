package com.ferdifir.netplix.ui.favorite

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ferdifir.netplix.MyApplication
import com.ferdifir.netplix.core.ui.SportsAdapter
import com.ferdifir.netplix.databinding.ActivityFavoriteBinding
import com.ferdifir.netplix.ui.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding
    //private lateinit var viewModel: FavoriteViewModel

    private val viewModel: FavoriteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        //(application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        val v = binding.root
        setContentView(v)

        val sportAdapter = SportsAdapter()
        sportAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        //val factory = ViewModelFactory.getInstance(this)
        //viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

        viewModel.favoriteSport.observe(this) { sport ->
            sportAdapter.setData(sport)
            //binding.viewEmpty.root.visibility = if (dataTourism.isNotEmpty()) View.GONE else View.VISIBLE
        }

        with(binding.rvSports) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = sportAdapter
        }
    }

}