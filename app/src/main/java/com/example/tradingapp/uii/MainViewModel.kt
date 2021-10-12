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
import kot