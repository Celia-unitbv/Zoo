package com.example.zoo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.zoo.data.Animal
import com.example.zoo.data.AppDatabase
import com.example.zoo.data.AnimalDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnimalViewModel(application: Application) : AndroidViewModel(application) {

    private val animalDao: AnimalDao
    private val allAnimals: LiveData<List<Animal>>

    init {
        val db = AppDatabase.getDatabase(application)
        animalDao = db.animalDao()
        allAnimals = animalDao.getAllAnimals()
    }

    fun getAllAnimals(): LiveData<List<Animal>> {
        return allAnimals
    }

    fun insert(animal: Animal) {
        viewModelScope.launch(Dispatchers.IO) {
            animalDao.insert(animal)
        }
    }

    fun update(animal: Animal) {
        viewModelScope.launch(Dispatchers.IO) {
            animalDao.update(animal)
        }
    }

    fun delete(animal: Animal) {
        viewModelScope.launch(Dispatchers.IO) {
            animalDao.delete(animal)
        }
    }
}
