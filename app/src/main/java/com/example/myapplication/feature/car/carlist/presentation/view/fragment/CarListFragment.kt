package com.example.myapplication.feature.car.carlist.presentation.view.fragment


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.entity.car.Car
import com.example.myapplication.feature.car.cardetail.CarDetailActivity
import com.example.myapplication.feature.car.carlist.presentation.CarPresentation
import com.example.myapplication.feature.car.carlist.presentation.presenter.CarPresenterImpl
import com.example.myapplication.feature.car.carlist.presentation.view.adapter.CarAdapter
import kotlinx.android.synthetic.main.fragment_car_list.*

/**
 * A simple [Fragment] subclass.
 */
class CarListFragment : Fragment(), CarPresentation.View {

    companion object {
        const val TAG = "CarListFragment"
    }

    private val presenter : CarPresentation.Presenter by lazy {
        CarPresenterImpl(this)
    }

    private val adapter : CarAdapter by lazy {
        CarAdapter(
            onItemClickListener = {
                val intent = Intent(context, CarDetailActivity::class.java)
                intent.putExtra("car", it)
                startActivity(intent)
            })
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
        initRecyclerView()
        presenter.fetchCarList()
    }

    private fun initRecyclerView(){
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
    }

    override fun showCarList(carList: MutableList<Car>) {
        adapter.addItem(carList)
    }

    override fun showLoading() {
        progress_bar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progress_bar.visibility = View.GONE
    }

    override fun showError() {
        Toast.makeText(context, getString(R.string.error_msg), Toast.LENGTH_SHORT).show()
    }
}
