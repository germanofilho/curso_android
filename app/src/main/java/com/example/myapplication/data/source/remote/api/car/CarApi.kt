package com.example.myapplication.data.source.remote.api.car

import com.example.myapplication.data.entity.car.Car
import io.reactivex.Observable
import retrofit2.http.GET

interface CarApi {
    @GET("carro")
    fun getCarList(): Observable<MutableList<Car>>
}

