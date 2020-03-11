package com.example.myapplication.feature.car.presentation.presenter

import com.example.myapplication.feature.car.model.CarModel
import com.example.myapplication.feature.car.model.usecase.CarUseCaseImpl
import com.example.myapplication.feature.car.presentation.CarPresentation

class CarPresenterImpl(private val view: CarPresentation.View) : CarPresentation.Presenter {

    private val useCase : CarModel.UseCase by lazy {
        CarUseCaseImpl()
    }

    override fun fetchCarList() {
        view.showCarList(useCase.fetchCarList())
    }
}
