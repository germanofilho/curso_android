package com.example.myapplication.feature.car.carlist.presentation.presenter

import com.example.myapplication.data.entity.car.Car
import com.example.myapplication.feature.car.carlist.model.CarModel
import com.example.myapplication.feature.car.carlist.model.usecase.CarUseCaseImpl
import com.example.myapplication.feature.car.carlist.presentation.CarPresentation
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response


class CarPresenterImpl(private val view: CarPresentation.View) : CarPresentation.Presenter {

    private val useCase : CarModel.UseCase by lazy {
        CarUseCaseImpl()
    }

    override fun fetchCarList() {
        useCase.fetchCarList().enqueue(object : Callback<MutableList<Car>> {

            override fun onResponse(call: Call<MutableList<Car>>, response: Response<MutableList<Car>>) {
                response.body()?.let {
                    view.showCarList(response.body()!!)
                }
            }

            override fun onFailure(call: Call<MutableList<Car>>, t: Throwable) {
                    view.showError()
            }
        })
    }
}
