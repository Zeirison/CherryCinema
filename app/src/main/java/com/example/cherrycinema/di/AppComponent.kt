package com.example.cherrycinema.di

import com.example.cherrycinema.App
import dagger.Component
import dagger.android.AndroidInjectionModule

@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivitiesModule::class,
        RepositoriesModule::class,
        DataSourceModule::class,
        FragmentsModule::class,
        ViewModelModule::class,
        AdapterModule::class,
        NetworkModule::class,
        AppModule::class
    ]
)
interface AppComponent {
    fun inject(app: App)
}