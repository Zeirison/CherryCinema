package com.example.cherrycinema.di

import com.example.cherrycinema.data.remote.api.MovieService
import com.example.cherrycinema.data.remote.network.AuthInterceptor
import com.example.cherrycinema.utils.API_KEY
import com.example.cherrycinema.utils.API_URL
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        objectMapper: ObjectMapper
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(API_URL)
            .client(okHttpClient)
            .addConverterFactory(JacksonConverterFactory.create(objectMapper))
            .build()
    }

    @Provides
    fun provideOkHttpClient(
        authInterceptor: AuthInterceptor,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient().newBuilder().addInterceptor(authInterceptor)
            .addInterceptor(loggingInterceptor).build()
    }

    @Provides
    fun provideObjectMapper(): ObjectMapper {
        val mapper = ObjectMapper()
        mapper.registerKotlinModule()
        val module = SimpleModule()
        mapper.registerModule(module)
        return mapper
    }

    @Provides
    fun provideAuthInterceptor(): AuthInterceptor =
        AuthInterceptor(API_KEY)

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BASIC
        return logger
    }

    @Provides
    fun provideMovieRetrofiteService(
        retrofit: Retrofit
    ): MovieService {
        return retrofit.create(MovieService::class.java)
    }
}
