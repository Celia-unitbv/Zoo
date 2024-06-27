package com.example.zoo.adapters

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.zoo.R
import com.example.zoo.data.Animal
import com.example.zoo.data.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ZooListAdapter(
    private val context: Context,
    private var animals: List<Animal>,
    private val navController: NavController
) : RecyclerView.Adapter<ZooListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.animal_name)
        val continentTextView: TextView = itemView.findViewById(R.id.animal_continent)
        val dividerView: View = itemView.findViewById(R.id.divider_view)
        val deleteButton: Button = itemView.findViewById(R.id.delete_button)

        init {
            deleteButton.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val animal = animals[position]
                    deleteItem(animal)
                }
            }
        }

        private fun deleteItem(animal: Animal) {
            // Delete from Room database
            val db = AppDatabase.getDatabase(itemView.context)
            val animalDao = db.animalDao()

            CoroutineScope(Dispatchers.IO).launch {
                animalDao.delete(animal)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.zoo_list_item_vertical, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val animal = animals[position]
        holder.nameTextView.text = animal.name
        holder.continentTextView.text = animal.continent
        // You can set other properties here if needed
    }

    override fun getItemCount(): Int {
        return animals.size
    }

    fun updateAnimals(newAnimals: List<Animal>) {
        animals = newAnimals
        notifyDataSetChanged()
    }


}

