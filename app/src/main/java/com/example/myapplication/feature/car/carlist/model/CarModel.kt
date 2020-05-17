package com.example.myapplication.feature.car.carlist.model

import com.example.myapplication.data.entity.car.Car
import io.reactivex.Observable

interface CarModel {

    interface UseCase{
        fun fetchCarList() : Observable<MutableList<Car>>
    }

    interface Repository{
        fun fetchCarList(): Observable<MutableList<Car>>
    }
}
