package com.example.tradingapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tradingapp.db.UserDetailsDao
import com.example.tradingapp.model.UserDetails

@Database(entities = [UserDetails::class], version = 1)
abstract class AppDatabase:RoomDatabase() {

    abstract fun userDetailsDao(): UserDetailsDao

}