package com.example.zoo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.zoo.data.Animal
import com.example.zoo.data.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

            if (name.isNotBlank() && continent.isNotBlank()) {
                lifecycleScope.launch {
                    val db = AppDatabase.getDatabase(applicationContext)
                    val animalDao = db.animalDao()

                    var existingAnimal = withContext(Dispatchers.IO) {
                        animalDao.getAnimalByName(name.lowercase())
                    }

                    if (existingAnimal != null) {
                        existingAnimal = existingAnimal.copy(continent = continent)
                        animalDao.update(existingAnimal)

                    }
                        if (isValidContinent(continent)) {
                            val newAnimal = Animal(name = name, continent = continent)
                            animalDao.insert(newAnimal)
                            showMessage("Animal added successfully")
                        } else {
                            showMessage("Invalid continent")
                        }
                }
            } else {
                showMessage("Please fill in all fields")
            }
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, ZooListFragment())
            .commit()
    }

    private fun showMessage(message: String) {
        AlertDialog.Builder(this)
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show()
    }

    private fun isValidContinent(continent: String): Boolean {

        val validContinents = listOf("Europe", "Africa", "Asia", "North America", "South America", "Australia", "Antarctica")
        return validContinents.contains(continent)
    }
}
