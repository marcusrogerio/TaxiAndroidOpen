package com.opentaxi.android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.littlefluffytoys.littlefluffylocationlibrary.LocationInfo;
import com.littlefluffytoys.littlefluffylocationlibrary.LocationLibraryConstants;
import com.opentaxi.android.asynctask.SendCoordinatesTask;
import com.opentaxi.android.utils.AppPreferences;

import java.util.Date;

public class UserGpsBroadcastReceiver extends BroadcastReceiver {

    static final String TAG = "UserGpsBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {


        final LocationInfo locationInfo = (LocationInfo) intent.getSerializableExtra(LocationLibraryConstants.LOCATION_BROADCAST_EXTRA_LOCATIONINFO);
        //locationInfo.refresh(context);
        Log.i("LocationBroadcastReceiver", "onReceive: received location update:" + locationInfo.lastLat + ", " + locationInfo.lastLong);

        new SendCoordinatesTask(locationInfo.lastLat, locationInfo.lastLong, locationInfo.lastLocationUpdateTimestamp).execute(context);

        if (AppPreferences.getInstance() != null) {

            Date now = new Date();
            AppPreferences.getInstance().setNorth((double) locationInfo.lastLat);
            AppPreferences.getInstance().setEast((double) locationInfo.lastLong);
            AppPreferences.getInstance().setCurrentLocationTime(locationInfo.lastLocationBroadcastTimestamp);
            AppPreferences.getInstance().setGpsLastTime(now.getTime());
        }
    }
}