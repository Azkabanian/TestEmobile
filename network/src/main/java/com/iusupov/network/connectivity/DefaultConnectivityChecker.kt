package com.iusupov.network.connectivity

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.iusupov.data.connectivity.ConnectivityChecker
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class DefaultConnectivityChecker @Inject constructor(
    @ApplicationContext private val context: Context
) : ConnectivityChecker {
    @SuppressLint("MissingPermission")
    override fun hasInternetAccess(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork
        val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
        return networkCapabilities != null &&
                networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
}
