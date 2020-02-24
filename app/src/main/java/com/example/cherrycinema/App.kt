package com.example.cherrycinema

import android.app.Application
import com.example.cherrycinema.di.AppComponent
import com.example.cherrycinema.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    val appComponent: AppComponent = DaggerAppComponent.create()

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }

}