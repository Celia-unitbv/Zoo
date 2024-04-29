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
            "Europa" -> {
                holder.itemView.setBackgroundColor(context.getColor(R.color.green))
                holder.nameTextView.textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                holder.continentTextView.textAlignment = View.TEXT_ALIGNMENT_TEXT_START
            }
            "Africa" -> {
                holder.itemView.setBackgroundColor(context.getColor(R.color.yellow))
                holder.nameTextView.textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                holder.continentTextView.textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                holder.nameTextView.setPadding(0, 0, 0, 5)
                holder.continentTextView.setPadding(0, 0, 0, 5)
                holder.nameTextView.append("\n----------------\n")
            }
            "Asia" -> {
                holder.itemView.setBackgroundColor(context.getColor(R.color.red))
                holder.nameTextView.textAlignment = View.TEXT_ALIGNMENT_CENTER
                holder.continentTextView.textAlignment = View.TEXT_ALIGNMENT_CENTER
                holder.nameTextView.setPadding(0, 0, 0, 5)
                holder.continentTextView.setPadding(0, 0, 0, 5)
                holder.nameTextView.append("\n----------------\n")
            }
            "America de Nord" -> {
                holder.itemView.setBackgroundColor(context.getColor(R.color.brown))
                holder.nameTextView.textAlignment = View.TEXT_ALIGNMENT_TEXT_END
                holder.continentTextView.textAlignment = View.TEXT_ALIGNMENT_TEXT_END
            }
            "America de Sud" -> {
                holder.itemView.setBackgroundColor(context.getColor(R.color.orange))
                holder.nameTextView.textAlignment = View.TEXT_ALIGNMENT_TEXT_END
                holder.continentTextView.textAlignment = View.TEXT_ALIGNMENT_TEXT_END
                holder.nameTextView.setPadding(0, 0, 0, 5)
                holder.continentTextView.setPadding(0, 0, 0, 5)
                holder.nameTextView.append("\n----------------\n")
            }
            "Australia" -> {
                holder.itemView.setBackgroundColor(context.getColor(R.color.purple))
                holder.nameTextView.textAlignment = View.TEXT_ALIGNMENT_CENTER
                holder.continentTextView.textAlignment = View.TEXT_ALIGNMENT_CENTER
            }
            "Antarctica" -> {
                holder.itemView.setBackgroundColor(context.getColor(R.color.blue))
                holder.nameTextView.textAlignment = View.TEXT_ALIGNMENT_CENTER
                holder.continentTextView.textAlignment = View.TEXT_ALIGNMENT_CENTER
                holder.nameTextView.setPadding(0, 0, 0, 5)
                holder.continentTextView.setPadding(0, 0, 0, 5)
                holder.nameTextView.append("\n----------------\n")
            }
        }
    }


    override fun getItemCount(): Int {
        return animals.size
    }
}
