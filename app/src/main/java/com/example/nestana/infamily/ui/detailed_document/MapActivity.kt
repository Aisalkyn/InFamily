package com.example.nestana.infamily.ui.detailed_document

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.FragmentActivity
import android.view.View
import com.example.nestana.infamily.R
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*


class MapActivity : FragmentActivity(), OnMapReadyCallback, GoogleMap.InfoWindowAdapter {

    private var mMap: GoogleMap? = null
    internal lateinit var mLocationRequest: LocationRequest
    private val LOCATION_PERMISSION = 100
    private var builder: LatLngBounds.Builder? = null
    //private var branches: List<Branch>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_map)
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }


    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap
        mMap!!.uiSettings.isZoomControlsEnabled = true
        mMap!!.setInfoWindowAdapter(this)
        requestLocationPermission()

        moveCameraDirection()
        setBranches()
    }


    fun setBranches() {
        builder = LatLngBounds.builder()
        //fillData()
        getData()
        moveCameraDirection()
    }

    private fun setMarker(latLng: LatLng, address: String) {
        val markerOptions = MarkerOptions()
                .anchor(0.5f, 0.5f) // Anchors the marker on the bottom left
                .position(LatLng(46.8, 74.3))
                .title("Bishkek")
                //.position(latLng)
                //.title(address)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.i_location))
        val m = mMap?.addMarker(markerOptions)
        builder?.include(m?.position)
    }


    private fun getData() {
        val intent = intent
        val address = intent.getStringExtra("address")
        val latitude = intent.getDoubleExtra("latitude", 0.0)
        val longitude = intent.getDoubleExtra("longitude", 0.0)
        setMarker(LatLng(latitude, longitude), address)
    }

    /*  private fun fillData() {
          if (branches != null && mMap != null) {
              mMap?.clear()
              for (i in branches!!.indices) {
                  setMarker(LatLng(branches!!.get(i).latitude!!,
                          branches!!.get(i).longitude!!),
                          branches!!.get(i).address!!
                  )
              }
          }
      }*/

    @SuppressLint("RestrictedApi")
    private fun requestLocationPermission() {
        mLocationRequest = LocationRequest()
        mLocationRequest.priority = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY
        if (ActivityCompat.checkSelfPermission(applicationContext, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(applicationContext, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION)
        } else {
            mMap!!.isMyLocationEnabled = true
        }
    }

    private fun moveCameraDirection() {
        if (mMap != null && builder != null) {
            try {
                val updatePosition = CameraUpdateFactory.newLatLngBounds(builder?.build(), 500, 500, 5)
                mMap?.animateCamera(updatePosition)
            } catch (e: Exception) {
                e.printStackTrace()
            }

        } else if (builder == null && mMap != null) {
            mMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(42.88200, 74.58274), 10f))
        }
    }


    override fun getInfoContents(marker: Marker?): View? {

        return null
    }

    override fun getInfoWindow(marker: Marker?): View? {
        return null

    }


}