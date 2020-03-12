package com.example.myapplication.feature.car.carlist.model.usecase

import com.example.myapplication.data.entity.car.Car
import com.example.myapplication.feature.car.carlist.model.CarModel
import com.example.myapplication.feature.car.carlist.model.repository.CarRepository
import retrofit2.Call

class CarUseCaseImpl : CarModel.UseCase {

    private val repository : CarModel.Repository by lazy {
        CarRepository()
    }

    override fun fetchCarList(): Call<MutableList<Car>> = repository.fetchCarList()

}
