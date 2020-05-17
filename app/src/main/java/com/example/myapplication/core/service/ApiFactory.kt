package com.example.myapplication.core.service

import com.example.myapplication.BuildConfig
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiFactory {
    fun <API> request(api : Class<API>) : API{
        return Retrofit.Builder()
                //Definindo o Base URL
            .baseUrl(BuildConfig.BASE_URL)
                //Adicionando o conversor do Json
            .addConverterFactory(GsonConverterFactory.create())
                //Habilitando o wrap response do retrofit para Observables do Rxjava
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //Criando o objeto Retrofit
            .build()
                //Criando essa instancia com a interface API do endpoint
            .create(api)
    }
}
