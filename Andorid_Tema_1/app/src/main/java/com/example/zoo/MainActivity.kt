// File: com/example/zoo/MainActivity.kt
package com.example.zoo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.zoo.data.Animal
import com.example.zoo.data.AppDatabase
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var nameEditText: EditText
    private lateinit var continentEditText: EditText
    private lateinit var addButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.edit_text_animal_name)
        continentEditText = findViewById(R.id.edit_text_continent)
        addButton = findViewById(R.id.button_add)

        addButton.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val continent = continentEditText.text.toString().trim()

            if (name.isNotEmpty() && continent.isNotEmpty()) {
                lifecycleScope.launch {
                    val db = AppDatabase.getDatabase(applicationContext)
                    val animalDao = db.animalDao()
                    val existingAnimal = animalDao.getAnimalByName(name)

                    if (existingAnimal != null) {
                        // Update existing animal
                        val updatedAnimal = existingAnimal.copy(continent = continent)
                        animalDao.update(updatedAnimal)
                    } else {
                        // Insert new animal
                        val newAnimal = Animal(name = name, continent = continent)
                        animalDao.insert(newAnimal)
                    }
                }
            } else {
                // Show error: Fields must not be empty
            }
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, ZooListFragment())
            .commit()
    }
}
