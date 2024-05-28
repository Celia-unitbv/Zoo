package com.example.zoo.adapters

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.zoo.R
import com.example.zoo.models.Animal

class ZooListAdapter(
    private val context: Context,
    private val animals: List<Animal>,
    private val navController: NavController
) : RecyclerView.Adapter<ZooListAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(animal: Animal)
    }

    var onItemClickListener: OnItemClickListener? = null

    companion object {
        private const val VIEW_TYPE_VERTICAL = 1
        private const val VIEW_TYPE_HORIZONTAL = 2
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val nameTextView: TextView = itemView.findViewById(R.id.animal_name)
        val continentTextView: TextView = itemView.findViewById(R.id.animal_continent)
        val dividerView: View = itemView.findViewById(R.id.divider_view)
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val currentDestination = navController.currentDestination
                if (currentDestination?.id == R.id.zooListFragment) {
                    val animal = animals[position]
                    val bundle = Bundle().apply {
                        putString("animalName", animal.name)
                        putString("animalContinent", animal.continent)
                    }
                    navController.navigate(R.id.action_zooListFragment_to_animalDetailsFragment, bundle)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutResourceId = when (viewType) {
            VIEW_TYPE_HORIZONTAL -> R.layout.zoo_list_item_horizontal
            else -> R.layout.zoo_list_item_vertical
        }
        val view = LayoutInflater.from(parent.context)
            .inflate(layoutResourceId, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val animal = animals[position]
        holder.nameTextView.text = animal.name
        holder.continentTextView.text = animal.continent
        

        when (animal.continent) {
            "Europe" -> {
                holder.itemView.setBackgroundColor(context.getColor(R.color.green))
                holder.nameTextView.gravity = Gravity.START
                holder.continentTextView.gravity = Gravity.START
                holder.dividerView.visibility = View.GONE
            }
            "Africa" -> {
                holder.itemView.setBackgroundColor(context.getColor(R.color.yellow))
                holder.nameTextView.gravity = Gravity.START
                holder.continentTextView.gravity = Gravity.START
                holder.dividerView.visibility = View.VISIBLE
            }
            "Asia" -> {
                holder.itemView.setBackgroundColor(context.getColor(R.color.red))
                holder.nameTextView.gravity = Gravity.START
                holder.continentTextView.gravity = Gravity.END
                holder.dividerView.visibility = View.VISIBLE
            }
            "North America" -> {
                holder.itemView.setBackgroundColor(context.getColor(R.color.brown))
                holder.nameTextView.gravity = Gravity.END
                holder.continentTextView.gravity = Gravity.END
                holder.dividerView.visibility = View.GONE
            }
            "South America" -> {
                holder.itemView.setBackgroundColor(context.getColor(R.color.orange))
                holder.nameTextView.gravity = Gravity.END
                holder.continentTextView.gravity = Gravity.END
                holder.dividerView.visibility = View.VISIBLE
            }
            "Australia" -> {
                holder.itemView.setBackgroundColor(context.getColor(R.color.purple))
                holder.nameTextView.gravity = Gravity.CENTER
                holder.continentTextView.gravity = Gravity.CENTER
                holder.dividerView.visibility = View.GONE
            }
            "Antarctica" -> {
                holder.itemView.setBackgroundColor(context.getColor(R.color.blue))
                holder.nameTextView.gravity = Gravity.CENTER
                holder.continentTextView.gravity = Gravity.CENTER
                holder.dividerView.visibility = View.VISIBLE
            }
        }
    }
    override fun getItemViewType(position: Int): Int {
        val animal = animals[position]
        return when (animal.continent) {
            "Asia" -> VIEW_TYPE_HORIZONTAL
            else -> VIEW_TYPE_VERTICAL
        }

    }
    override fun getItemCount(): Int {
        return animals.size
    }
}
