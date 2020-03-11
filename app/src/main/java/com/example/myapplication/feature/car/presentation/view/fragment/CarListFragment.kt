package com.example.myapplication.feature.car.presentation.view.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.entity.Car
import com.example.myapplication.feature.car.presentation.view.adapter.CarAdapter
import com.example.myapplication.R
import com.example.myapplication.feature.car.presentation.CarPresentation
import com.example.myapplication.feature.car.presentation.presenter.CarPresenterImpl
import kotlinx.android.synthetic.main.fragment_car_list.*

/**
 * A simple [Fragment] subclass.
 */
class CarListFragment : Fragment(), CarPresentation.View {
    
    private val presenter : CarPresentation.Presenter by lazy {
        CarPresenterImpl(this)
    }

    companion object {
        const val TAG = "CarListFragment"
    }

    private val adapter : CarAdapter by lazy {
        CarAdapter()
    }

    private val recyclerView : RecyclerView by lazy {
        rv_carlist
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_car_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.fetchCarList()
    }

    private fun initRecyclerView(){
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
    }

    
    override fun showCarList(carList: MutableList<Car>) {
        initRecyclerView()
        adapter.addItem(carList)
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
