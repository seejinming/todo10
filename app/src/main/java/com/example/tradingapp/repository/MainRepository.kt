
package com.example.tradingapp.repository

import com.example.tradingapp.data.api.ApiService
import com.example.tradingapp.db.UserDetailsDao
import com.example.tradingapp.model.UserDetails
import kotlinx.coroutines.*
import javax.inject.Inject
import javax.inject.Singleton


@ExperimentalCoroutinesApi
@Singleton
class MainRepository @Inject constructor(val userDetailsDao: UserDetailsDao,val apiService: ApiService) {


    fun insert(userDetails: UserDetails){
        CoroutineScope(Dispatchers.Default).launch {
            userDetailsDao.insert(userDetails)
        }
    }

    suspend fun getDetails():List<UserDetails>{
        return CoroutineScope(Dispatchers.Default).async {
            return@async userDetailsDao.getAllUsers()
        }.await()
    }

    suspend fun getDetailsAPi() =  apiService.getProductDetaills()

}