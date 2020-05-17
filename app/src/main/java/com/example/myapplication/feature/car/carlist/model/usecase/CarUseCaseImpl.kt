package com.example.myapplication.feature.car.carlist.model.usecase

import com.example.myapplication.data.entity.car.Car
import com.example.myapplication.feature.car.carlist.model.CarModel
import io.reactivex.Observable

class CarUseCaseImpl(private val repository: CarModel.Repository) : CarModel.UseCase {

    override fun fetchCarList(): Observable<MutableList<Car>> = repository.fetchCarList()

}
