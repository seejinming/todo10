package com.example.tradingapp.uii.chart

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tradingapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart)
    }
}