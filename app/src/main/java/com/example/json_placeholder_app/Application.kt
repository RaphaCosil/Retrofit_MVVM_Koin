package com.example.json_placeholder_app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            modules(utilsModule, networkModule, dataModule, domainModule, presentationModule)
        }
    }
}