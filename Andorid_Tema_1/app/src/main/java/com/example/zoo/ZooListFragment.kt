package com.example.zoo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zoo.adapters.ZooListAdapter
import com.example.zoo.models.Animal

class ZooListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_zoo_list, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.animal_list)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        // Crearea unei liste de animale de exemplu (înlocuiește cu datele tale reale)
        val animals = listOf(
            Animal("Leu", "Africa"),
            Animal("Elefant", "Africa"),
            Animal("Tigru", "Asia"),
            Animal("Pisica", "Europa"),
            Animal("Ornitoring", "America de Sud"),
            Animal("Urs alb", "Antarctica"),

            // Adaugă mai multe animale pentru fiecare continent
        )

        // Creează un adaptor pentru RecyclerView și atașează-l
        val adapter = ZooListAdapter(requireContext(), animals)
        recyclerView.adapter = adapter

        return view
    }

}
