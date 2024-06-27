// File: com/example/zoo/ZooListFragment.kt
package com.example.zoo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zoo.adapters.ZooListAdapter
import com.example.zoo.data.Animal
import com.example.zoo.data.AppDatabase
import kotlinx.coroutines.launch

// ZooListFragment.kt
class ZooListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_zoo_list, container, false)
        recyclerView = view.findViewById(R.id.animal_list)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        setupRecyclerView()

        return view
    }

    private fun setupRecyclerView() {
        lifecycleScope.launch {
            val db = AppDatabase.getDatabase(requireContext())
            val animalsLiveData = db.animalDao().getAllAnimals()

            animalsLiveData.observe(viewLifecycleOwner, Observer { animals ->
                val navController = findNavController()
                val adapter = ZooListAdapter(requireContext(), animals, navController)
                recyclerView.adapter = adapter
            })
        }
    }
}


