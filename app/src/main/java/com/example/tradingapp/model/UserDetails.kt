
package com.example.tradingapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_details")
data class UserDetails(
    @PrimaryKey
    var uuid:Int? = null,
    val emailId: String,
    var password: String,
    var loginType: Int
)