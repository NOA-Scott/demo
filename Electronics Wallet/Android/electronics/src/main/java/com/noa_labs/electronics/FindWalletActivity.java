package com.noa_labs.electronics;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.noa_labs.electronics.util.PermissionUtils;

/**
 * Created by Scott on 2016/7/15.
 */
public class FindWalletActivity extends BaseActivity implements
        GoogleMap.OnInfoWindowClickListener,
        OnMapReadyCallback,
        GoogleMap.OnMarkerDragListener,
        GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnMarkerClickListener,
        SeekBar.OnSeekBarChangeListener,
        GoogleMap.OnInfoWindowLongClickListener,
        GoogleMap.OnInfoWindowCloseListener {

    private static final String TAG = "FindWalletActivity";

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;

    private boolean mPermissionDenied = false;

    private GoogleMap mMap;

    private Marker mBrisbane;
    private static final LatLng BRISBANE = new LatLng(22.52825400732604, 114.11224302734378);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Permission to access the location is missing.
            PermissionUtils.requestPermission(this, LOCATION_PERMISSION_REQUEST_CODE, Manifest.permission.ACCESS_FINE_LOCATION, true);
        } else if (mMap != null) {
            // Access to the location has been granted to the app.
            mMap.setMyLocationEnabled(true);
        }
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.e(TAG, "onMapReady     ");
        mMap = googleMap;

        mMap.setOnMyLocationButtonClickListener(this);

        enableMyLocation();


        mBrisbane = mMap.addMarker(new MarkerOptions()
                .position(BRISBANE)
                .title("My Wallet")
                .snippet("click look my wallet detailed information")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.wallet))
                //.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
                .infoWindowAnchor(0.5f, 0.5f)
                .draggable(true));

        mMap.setOnMarkerClickListener(this);
        mMap.setOnInfoWindowClickListener(this);
        mMap.setOnMarkerDragListener(this);
        mMap.setOnInfoWindowCloseListener(this);
        mMap.setOnInfoWindowLongClickListener(this);

    }

    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
            return;
        }

        if (PermissionUtils.isPermissionGranted(permissions, grantResults,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            // Enable the my location layer if the permission has been granted.
            enableMyLocation();
        } else {
            // Display the missing permission error dialog when the fragments resume.
            mPermissionDenied = true;
        }
    }


    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        if (mPermissionDenied) {
            // Permission was not granted, display error dialog.
            showMissingPermissionError();
            mPermissionDenied = false;
        }
    }

    private void showMissingPermissionError() {
        PermissionUtils.PermissionDeniedDialog.newInstance(true).show(getSupportFragmentManager(), "dialog");
    }

    @Override
    public void onMarkerDragStart(Marker marker) {
        Log.e(TAG, "  onMarkerDragStart  ");
    }

    @Override
    public void onMarkerDrag(Marker marker) {
        Log.e(TAG, "  onMarkerDrag  ");
    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        Log.e(TAG, "  onMarkerDragEnd  ");
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Log.e(TAG, "  onInfoWindowClick  ");
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Log.e(TAG, "  onMarkerClick  ");
        if(marker.equals(mBrisbane)){
            Toast.makeText(this," onMarkerClick  ",Toast.LENGTH_LONG).show();
        }
        return false;
    }

    @Override
    public void onInfoWindowClose(Marker marker) {
        Log.e(TAG, "  onInfoWindowClose  ");
    }

    @Override
    public void onInfoWindowLongClick(Marker marker) {
        Log.e(TAG, "  onInfoWindowLongClick  ");
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Log.e(TAG, "  onProgressChanged  ");
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        Log.e(TAG, "  onStartTrackingTouch  ");
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        Log.e(TAG, "  onStopTrackingTouch  ");
    }
}
