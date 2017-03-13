package com.example.gps;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

 @SuppressLint("NewApi") public class MainActivity extends ActionBarActivity implements LocationListener{

	private LocationManager locationmanager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locationmanager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationmanager.requestLocationUpdates( LocationManager.GPS_PROVIDER,1000,10, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		 String str = "Latitude: "+location.getLatitude()+"Longitude: "+location.getLongitude();
		 Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		Toast.makeText(getBaseContext(), "Gps turned off ", Toast.LENGTH_LONG).show();
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		Toast.makeText(getBaseContext(), "Gps turned on ", Toast.LENGTH_LONG).show();
	}

	@Override
	public void onStatusChanged(String arg0, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}
}
