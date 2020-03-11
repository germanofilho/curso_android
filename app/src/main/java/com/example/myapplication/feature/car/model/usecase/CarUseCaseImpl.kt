package com.example.myapplication.feature.car.model.usecase

import com.example.myapplication.data.entity.Car
import com.example.myapplication.feature.car.model.CarModel

class CarUseCaseImpl : CarModel.UseCase {

    override fun fetchCarList(): MutableList<Car> {
        val carList : MutableList<Car> = mutableListOf()
        for(i in 1..10){
            carList.add(
                Car(
                    1, "Honda Fit", "",
                    "Honda", "20", 200.000, ""
                )
            )
        }

        return carList
    }
}