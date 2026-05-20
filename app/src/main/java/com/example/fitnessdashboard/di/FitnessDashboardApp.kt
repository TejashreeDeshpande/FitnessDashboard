package com.example.fitnessdashboard.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FitnessDashboardApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@FitnessDashboardApp)
            modules(appModule)
        }
    }
}