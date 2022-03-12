package com.sourabhverma.sourabhcitsworldwide

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo


object ConnectionManager {
    fun checkConnection(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo != null
        }
        return false
    }
}