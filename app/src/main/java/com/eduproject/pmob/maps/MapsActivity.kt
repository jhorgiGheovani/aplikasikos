package com.eduproject.pmob.maps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.eduproject.pmob.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.eduproject.pmob.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.LatLngBounds

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.uiSettings.isIndoorLevelPickerEnabled = true
        mMap.uiSettings.isCompassEnabled = true
        mMap.uiSettings.isMapToolbarEnabled = true

        //value makin kecil= makin jauh
        mMap.setMinZoomPreference(5.0f)//jarak paling jauh
        mMap.setMaxZoomPreference(14.0f) //jarak zoom paling deket

        val lat = intent.getDoubleExtra("lat",0.0)
        val lon = intent.getDoubleExtra("lon", 0.0)
        val name = intent.getStringExtra("name")
        Log.d("KOORDINAT", "${lat}, ${lon}")


        addingMarker(lat,lon,name.toString())
    }

    private val boundsBuilder = LatLngBounds.Builder()
    private fun addingMarker(lat: Double, lon:Double, name:String){
        val latLng = LatLng(lon, lat)
        mMap.addMarker(
            MarkerOptions()
                .position(latLng)
                .title(name)
        )
        boundsBuilder.include(latLng)
        val bounds: LatLngBounds = boundsBuilder.build()
        mMap.animateCamera(
            CameraUpdateFactory.newLatLngBounds(
                bounds,
                resources.displayMetrics.widthPixels,
                resources.displayMetrics.heightPixels,
                30
            )
        )
    }


}