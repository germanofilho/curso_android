package com.example.myapplication.data.source.remote.api.car

import com.example.myapplication.data.entity.car.Car
import retrofit2.Call
import retrofit2.http.GET

interface CarApi{

    @GET("carro")
    fun getCarList(): Call<MutableList<Car>>

}

