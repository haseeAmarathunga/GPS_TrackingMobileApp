package com.notation.haseeclash.gpstracking_system;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by HaseeClash on 3/20/2018.
 */

public class GPSTacking extends Service implements LocationListener {
    private final Context mContext;

    boolean isGPSEnable = false;

    boolean isNetworkEnable= false;

    boolean canGetLocation =false;

    Location location;

    double latitude;
    double logitude;

    private static final long MIN_DIS_FOR_UPDATES = 10;
    private static final long MIN_TIME_BW_UPDATES = 1000*60*1;

    protected LocationManager locationManager;

    private GPSTacking(Context context){
        this.mContext=context;
        getLocation();
    }

    public void getLocation(){
        try {
            locationManager=(LocationManager) mContext.getSystemService(LOCATION_SERVICE);
            isGPSEnable=locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            isNetworkEnable=locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if (!isGPSEnable && !isNetworkEnable){

            }
            else{
                canGetLocation=true;
                /*if(isNetworkEnable){
                    if()
                }*/
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }








    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
