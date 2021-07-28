package com.example.tradingapp.db

import androidx.room.*
import com.example.tradingapp.model.UserDetails

@Dao
interface UserDetailsDao {

    @Insert
    fun insert(user: UserDetails)

    