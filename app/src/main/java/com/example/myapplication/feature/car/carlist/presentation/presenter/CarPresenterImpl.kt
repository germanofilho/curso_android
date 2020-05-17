package com.example.myapplication.feature.car.carlist.presentation.presenter

import com.example.myapplication.feature.car.carlist.model.CarModel
import com.example.myapplication.feature.car.carlist.presentation.CarPresentation
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class CarPresenterImpl(val view: CarPresentation.View,private val useCase: CarModel.UseCase) : CarPresentation.Presenter {

    private val compositeDisposable by lazy { CompositeDisposable() }

    override fun fetchCarList() {
        view.showLoading()
        val disposable = useCase.fetchCarList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally {
                view.hideLoading()
                compositeDisposable.clear()
            }
            .subscribe({
                if(!it.isNullOrEmpty()){
                    view.showCarList(it)
                } else {
                    view.showError()
                }
            },{
                view.showError()
            })

        compositeDisposable.add(disposable)
    }
}