package org.sopt.carrot

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import timber.log.Timber

class CarrotApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }

    private fun setTimber() {
        Timber.plant(Timber.DebugTree())
    }

    private fun setDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

}