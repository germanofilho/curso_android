package com.example.myapplication.feature.car.cardetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.data.entity.car.Car
import kotlinx.android.synthetic.main.activity_car_detail.*

class CarDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_detail)

        val car = intent.getParcelableExtra<Car>("car")

        setupToolBar(car?.nome)
    }


    private fun setupToolBar(carName: String?){
        toolbar.title = carName
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
