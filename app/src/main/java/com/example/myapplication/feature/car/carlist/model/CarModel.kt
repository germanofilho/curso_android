package com.example.myapplication.feature.car.carlist.model

import com.example.myapplication.data.entity.car.Car
import retrofit2.Call

interface CarModel {

    interface UseCase{
        fun fetchCarList() : Call<MutableList<Car>>
    }

    interface Repository{
        fun fetchCarList(): Call<MutableList<Car>>
    }
}