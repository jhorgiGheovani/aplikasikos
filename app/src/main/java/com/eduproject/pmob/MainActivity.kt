package com.eduproject.pmob

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.eduproject.pmob.databinding.ActivityMainBinding
import com.eduproject.pmob.maps.MapsActivity
import com.eduproject.pmob.rvlistkos.ListAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels {
        ViewModelFactory((application as MyApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val layoutManager = GridLayoutManager(this,2)
        binding.rvKosan.layoutManager = layoutManager
        mainViewModel.getKosan().observe(this){
            val adapter = ListAdapter(it){onClick->
                val intent = Intent(this, MapsActivity::class.java)
                intent.putExtra("lat", onClick.lat)
                intent.putExtra("lon", onClick.lon)
                intent.putExtra("name", onClick.name)
                startActivity(intent)
            }
            binding.rvKosan.adapter = adapter
        }

    }
}