package com.sriyank.globotour.city

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sriyank.globotour.R


class CityListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_city_list, container, false)

        setupRecyclerView(view)

        return view
    }

    private fun setupRecyclerView(view: View?) {

        val context = requireContext()

        val cityAdapter = CityAdapter(context, VacationSpots.cityList!!)

        //inicializamos el recyclerView
        val recyclerView = view?.findViewById<RecyclerView>(R.id.city_recycler_view)

        //configuramos el adapter
        recyclerView?.adapter = cityAdapter

        //si el recyclerView nunca camvia su ancho o alto en el tiempo de ejecución
        //entonces debe establecerlo verdadero
        // ya que esto incrementará el rendimiento de la app
        recyclerView?.setHasFixedSize(true)

        //ahora tenemos que definir nuestro administrador de diseño(layoutManager)
        val layoutManager = LinearLayoutManager(context)
        // y configurarlo con en nuestro recyclerView
        layoutManager.orientation = RecyclerView.VERTICAL
        recyclerView?.layoutManager = layoutManager
    }
}