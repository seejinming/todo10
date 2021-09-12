package com.example.tradingapp.module

import android.content.Context
import androidx.room.Room
import com.example.tradingapp.data.api.ApiService
import com.example.tradingapp.data.remote.AppConstent.baseUrl
import com.example.tradingapp.db.AppDatabase
import com.example.tradingapp.db.UserDetailsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class AppModule {



    @Provides
    fun provideUserDao(appDatabase: AppDatabase): UserDetailsDao {
        return appDatabase.userDetailsDao()
    }


    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext:Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "EFarmerDb"
        ).build()
    }

    @Singleton
    @Provides
    fun providerApiService():ApiService{
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            // we need to add converter factory to
            // convert JSON object to Java object
            .build()

            .create(ApiService::class.java)
    }
}