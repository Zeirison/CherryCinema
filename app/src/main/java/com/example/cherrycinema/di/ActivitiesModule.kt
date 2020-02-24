package com.example.cherrycinema.di

import com.example.cherrycinema.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

}