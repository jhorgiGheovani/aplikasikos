package com.eduproject.pmob

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.eduproject.pmob.data.entity.MainEntity
import com.eduproject.pmob.databinding.ActivityMainBinding
import com.eduproject.pmob.maps.MapsActivity
import com.eduproject.pmob.rvlistkos.ListAdapter
import java.net.URLEncoder


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
            val adapter = ListAdapter(it, onMapsClick, onPhoneClick)
            binding.rvKosan.adapter = adapter
        }

    }
    private val onMapsClick: (MainEntity)->Unit= {mainEntity ->
        val intent = Intent(this, MapsActivity::class.java)
        intent.putExtra("lat", mainEntity.lat)
        intent.putExtra("lon", mainEntity.lon)
        intent.putExtra("name", mainEntity.name)
        startActivity(intent)
    }
    private val onPhoneClick: (MainEntity)->Unit= {mainEntity ->
        try {
            val phoneNumber = "+6283844034043"
            val message = "Min, ${mainEntity.name} apakah masih ada?"
            val url = "https://api.whatsapp.com/send?phone=$phoneNumber&text=${URLEncoder.encode(message, "UTF-8")}"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)

            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            // Handle the case when WhatsApp is not installed
            Toast.makeText(this, "WhatsApp is not installed", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            // Handle other exceptions if needed
            Toast.makeText(this, "Error opening WhatsApp", Toast.LENGTH_SHORT).show()
        }


    }
}