package com.example.myapplication.core.di

import com.example.myapplication.feature.car.carlist.model.CarModel
import com.example.myapplication.feature.car.carlist.model.repository.CarRepository
import com.example.myapplication.feature.car.carlist.model.usecase.CarUseCaseImpl
import com.example.myapplication.feature.car.carlist.presentation.CarPresentation
import com.example.myapplication.feature.car.carlist.presentation.presenter.CarPresenterImpl
import org.koin.dsl.module

val homeModule = module {
    single {
        (view : CarPresentation.View) -> CarPresenterImpl(view, get()) as CarPresentation.Presenter
    }

    single {
        CarUseCaseImpl(get()) as CarModel.UseCase
    }

    single {
        CarRepository() as CarModel.Repository
    }
}

val favoriteModule = module {
    //another module
}
