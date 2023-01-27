package com.example.cocktailapp.data.remote.network

import com.example.cocktailapp.BuildConfig
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
//import com.example.cocktailapp.BuildConfig

//const val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/"

@Module
@InstallIn(SingletonComponent::class)
object CocktailApiModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit.Builder {

        val logging = HttpLoggingInterceptor()

        val gson = GsonBuilder().create()

        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClient: OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor(logging)

        return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson)).client(httpClient.build())
    }

    @Provides
    @Singleton
    fun provideApi(builder: Retrofit.Builder): CocktailApi {
        return builder.build().create(CocktailApi::class.java)
    }
}