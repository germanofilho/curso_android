package com.example.myapplication.feature.car.presentation.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.entity.Car
import com.example.myapplication.R
import kotlinx.android.synthetic.main.item_car.view.*

class CarAdapter : RecyclerView.Adapter<ViewHolder>(){

    private var cars = mutableListOf<Car>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_car, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = cars.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cars[position])
    }

    fun addItem(carList: MutableList<Car>){
        cars.addAll(carList)
        notifyDataSetChanged()
    }
}


class ViewHolder(private val view: View): RecyclerView.ViewHolder(view){
    fun bind(car: Car){
        with(view){
            tv_car_brand.text = car.marca
            tv_car_title.text = car.nome
            tv_car_quantity.text = car.quantidade
            tv_car_value.text = car.quantidade
        }
    }

}


