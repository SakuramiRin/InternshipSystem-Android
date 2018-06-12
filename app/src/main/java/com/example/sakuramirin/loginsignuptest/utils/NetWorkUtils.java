package com.example.sakuramirin.loginsignuptest.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;



public class NetWorkUtils{


    //网络是否可用
    public static boolean isNetWorkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager != null ? mConnectivityManager.getActiveNetworkInfo() : null;
            if (mNetworkInfo != null) {
                return !mNetworkInfo.isAvailable() || !mNetworkInfo.isConnected();
            }
        }
        return true;
    }


}
