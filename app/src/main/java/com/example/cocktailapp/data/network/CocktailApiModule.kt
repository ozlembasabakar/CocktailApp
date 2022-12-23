package com.example.cocktailapp.data.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

const val BASE_URL =
    "https://www.thecocktaildb.com/api/json/v1/1/"

@Module
@InstallIn(SingletonComponent::class)
object CocktailApiModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    @Provides
    @Singleton
    fun provideApi(builder: Retrofit.Builder): CocktailApi {
        return builder.build().create(CocktailApi::class.java)
    }
}