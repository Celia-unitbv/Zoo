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
            Animal("Hedgehog", "Europe"),
            Animal("Tern", "Antarctica"),
            Animal("Cobra", "Asia"),
            Animal("Kookaburra", "Australia"),
            Animal("Lion", "Africa"),
            Animal("Armadillo", "North America"),
            Animal("Frilled Lizard", "Australia"),
            Animal("Leopard", "Asia"),
            Animal("Rhinoceros", "Africa"),
            Animal("Emu", "Australia"),
            Animal("Anaconda", "South America"),
            Animal("Giraffe", "Africa"),
            Animal("Kangaroo", "Australia"),
            Animal("Seal", "Antarctica"),
            Animal("Rabbit", "Europe"),
            Animal("Panda", "Asia"),
            Animal("Fox", "Europe"),
            Animal("Ostrich", "Africa"),
            Animal("Orangutan", "Asia"),
            Animal("Blue Whale", "Antarctica"),
            Animal("Lynx", "Europe"),
            Animal("Little Penguin", "Australia"),
            Animal("Otter", "Europe"),
            Animal("Bison", "North America"),
            Animal("Peacock", "Asia"),
            Animal("Hyena", "Africa"),
            Animal("Snow Petrel", "Antarctica"),
            Animal("Platypus", "Australia"),
            Animal("Anteater", "South America"),
            Animal("Alligator", "North America"),
            Animal("Boar", "Europe"),
            Animal("Monkey", "Asia"),
            Animal("Capybara", "South America"),
            Animal("Dolphin", "South America"),
            Animal("Penguin", "Antarctica"),
            Animal("Horseshoe Crab", "North America"),
            Animal("Bears", "Antarctica"),
            Animal("Jaguar", "South America"),
            Animal("White Bear", "Antarctica"),
            Animal("Frog", "Europe"),
            Animal("Eagle", "South America"),
            Animal("Zebra", "Africa"),
            Animal("Boa Constrictor", "South America"),
            Animal("Tiger", "Asia"),
            Animal("Tufted Titmouse", "North America"),
            Animal("Ferret", "North America"),
            Animal("Scorpion", "North America"),
            Animal("Hyaena", "Africa"),
            Animal("Sea Turtle", "Australia"),
            Animal("Orcas", "Antarctica")
        )

        // Creează un adaptor pentru RecyclerView și atașează-l
        val adapter = ZooListAdapter(requireContext(), animals)
        recyclerView.adapter = adapter

        return view
    }

}
