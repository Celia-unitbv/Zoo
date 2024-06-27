// File: com/example/zoo/data/AnimalDao.kt
package com.example.zoo.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AnimalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(animal: Animal)

    @Query("SELECT * FROM animals")
    fun getAllAnimals(): LiveData<List<Animal>>

    @Query("SELECT * FROM animals WHERE LOWER(name) = LOWER(:name) LIMIT 1")
    suspend fun getAnimalByName(name: String): Animal?

    @Update
    suspend fun update(animal: Animal)

    @Delete
    suspend fun delete(animal: Animal)
}
