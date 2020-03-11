package com.example.myapplication.feature.car.model

import com.example.myapplication.data.entity.Car

interface CarModel {

    interface UseCase{
        fun fetchCarList() : MutableList<Car>
    }
}