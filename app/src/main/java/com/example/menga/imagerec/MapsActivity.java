package com.example.menga.imagerec;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        LatLng ucsd = new LatLng(32.88, -117.23);
        mMap.addMarker(new MarkerOptions().position(ucsd).title("Marker in UC San Diego"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ucsd));

        LatLng la = new LatLng(34.05, -118.24);
        mMap.addMarker(new MarkerOptions().position(la).title("Marker in Los Angeles"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(la));

        LatLng london = new LatLng(51.51, -0.13);
        mMap.addMarker(new MarkerOptions().position(london).title("Marker in London"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(london));

        LatLng paris = new LatLng(48.86, 2.35);
        mMap.addMarker(new MarkerOptions().position(paris).title("Marker in Paris"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(paris));

        LatLng beijing = new LatLng(39.90, 116.1);
        mMap.addMarker(new MarkerOptions().position(beijing).title("Marker in BeiJing"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(beijing));

        LatLng tokyo = new LatLng(35.69, 139.69);
        mMap.addMarker(new MarkerOptions().position(tokyo).title("Marker in Tokyo"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(tokyo));

        LatLng delhi = new LatLng(28.61, -77.21);
        mMap.addMarker(new MarkerOptions().position(delhi).title("Marker in New Delhi"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(delhi));

        LatLng jerusalem = new LatLng(31.77, -35.21);
        mMap.addMarker(new MarkerOptions().position(jerusalem).title("Marker in Jerusalem"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(jerusalem));
    }
}
