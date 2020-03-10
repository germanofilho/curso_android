package com.example.myapplication.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Car(val id: Int,
               val nome: String,
               val descricao: String,
               val marca: String,
               val quantidade: String,
               val preco: Double,
               val imagem: String) : Parcelable