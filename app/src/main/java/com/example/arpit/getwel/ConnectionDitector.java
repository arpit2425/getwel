package com.example.arpit.getwel;

import android.app.Service;
import android.content.Context;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectionDitector {
    Context context;

    public ConnectionDitector(Context context) {
        this.context = context;
    }
    public boolean isConnected()
    {
        ConnectivityManager connectivityManager=(ConnectivityManager)context.getSystemService(Service.CONNECTIVITY_SERVICE);
        if(connectivityManager!=null)
        {
            NetworkInfo info=connectivityManager.getActiveNetworkInfo();
            if(info!=null)
            {
                if(info.getState()==NetworkInfo.State.CONNECTED)
                {
                    return true;
                }
            }

        }
        return false;
    }
}
