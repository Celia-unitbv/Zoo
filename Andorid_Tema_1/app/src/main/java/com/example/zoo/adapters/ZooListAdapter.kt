package com.example.zoo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zoo.R
import com.example.zoo.models.Animal

class ZooListAdapter(private val context: Context, private val animals: List<Animal>) :
    RecyclerView.Adapter<ZooListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.animal_name)
        val continentTextView: TextView = itemView.findViewById(R.id.animal_continent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.zoo_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val animal = animals[position]
        holder.nameTextView.text = animal.name
        holder.continentTextView.text = animal.continent

        // Setează culoarea de fundal și alinierea în funcție de continent
        when (animal.continent) {
            "Europe" -> {
                holder.itemView.setBackgroundColor(context.getColor(R.color.green))
            }
            "Africa" -> {
                holder.itemView.setBackgroundColor(context.getColor(R.color.yellow))
            }
            "Asia" -> {
                holder.itemView.setBackgroundColor(context.getColor(R.color.red))
            }
            "North America" -> {
                holder.itemView.setBackgroundColor(context.getColor(R.color.brown))
            }
            "South America" -> {
                holder.itemView.setBackgroundColor(context.getColor(R.color.orange))
            }
            "Australia" -> {
                holder.itemView.setBackgroundColor(context.getColor(R.color.purple))
            }
            "Antarctica" -> {
                holder.itemView.setBackgroundColor(context.getColor(R.color.blue))
            }
        }
    }


    override fun getItemCount(): Int {
        return animals.size
    }
}
