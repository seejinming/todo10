package com.example.tradingapp.uii

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tradingapp.model.ProducutListResponce
import com.example.tradingapp.model.ResponseResource
import com.example.tradingapp.model.UserDetails
import com.example.tradingapp.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import retrofit2.Response
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class MainViewModel @Inject constructor(val repository: MainRepository):ViewModel(){

    fun  insert(userDetails: UserDetails){
        CoroutineScope(Dispatchers.Default).launch {
            repository.insert(userDetails)
        }

    }

    private val _getDetails = MutableLiveData<List<UserDetails>>()
    val getDetails:LiveData<List<UserDetails>> get() = _getDetails

    fun getDetails(){
        viewModelScope.launch {
            _getDetails.value = repository.getDetails()
        }
    }


    private val _getProductDetails = MutableLiveData<ResponseResource<Response<ProducutListResponce>>>()

    val getProductDetails: LiveData<ResponseResource<Response<ProducutListResponce>>>
        get() = _getProductDetails

    fun getProductDetails(){


        viewModelScope.launch {



            val data = viewModelScope.async {
                repository.getDetailsAPi()
            }

            val myData = data.await()

            if (myData.isSuccessful) {

                _getProductDetails.value = ResponseResource.success(myData)
            } else {

                _getProductDetails.value = ResponseResource.error("Something went wrong")
            }

        }

    }


}