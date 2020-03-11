package com.example.myapplication.feature.car.presentation

import com.example.myapplication.data.entity.Car

interface CarPresentation {
    interface View {
        fun showLoading()
        fun hideLoading()
        fun showCarList(carList : MutableList<Car>)
    }

    interface Presenter {
        fun fetchCarList()
    }
}