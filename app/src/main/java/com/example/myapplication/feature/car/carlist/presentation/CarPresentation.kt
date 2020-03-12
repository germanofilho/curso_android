package com.example.myapplication.feature.car.carlist.presentation

import com.example.myapplication.data.entity.car.Car

interface CarPresentation {
    interface View {
        fun showLoading()
        fun hideLoading()
        fun showError()
        fun showCarList(carList : MutableList<Car>)
    }

    interface Presenter {
        fun fetchCarList()
    }
}