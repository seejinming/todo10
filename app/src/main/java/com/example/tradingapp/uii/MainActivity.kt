package com.example.tradingapp.uii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.tradingapp.R
import com.example.tradingapp.model.ResponseResource
import com.example.tradingapp.model.UserDetails
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {



    val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initObservers()

        initLisiners()

    }

    private fun initObservers() {
        mainViewModel.getDetails.observe(this){

            viewListData.text = "$it"
        }

        mainViewModel.getProductDetails.observe(this){
            when(it.status){


                ResponseResource.Status.LOADING->{

                }ResponseResource.Status.SUCCESS->{

                viewListData.text = ""

                viewListData.text = "${it.data?.body()?.response}"

                }ResponseResource.Status.ERROR->{

                }
            }
        }
    }

    private fun initLisiners() {
        addData.setOnClickListener {

            mainViewModel.insert(
                UserDetails(
                    emailId = "wwg@gmail.com",
                    password = "sjdjkbs",
                    loginType=0
                )
            )
        }

        viewData.setOnClickListener {

//            mainViewModel.getDetails()
            mainViewModel.getProductDetails()

        }


    }
}