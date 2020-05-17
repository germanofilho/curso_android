package com.example.myapplication.feature.car.carlist.model.repository

import com.example.myapplication.core.service.ApiFactory
import com.example.myapplication.data.entity.car.Car
import com.example.myapplication.data.source.remote.api.car.CarApi
import com.example.myapplication.feature.car.carlist.model.CarModel
import io.reactivex.Observable

class CarRepository : CarModel.Repository {

    override fun fetchCarList(): Observable<MutableList<Car>> =
        ApiFactory().request(CarApi::class.java).getCarList()

}