package com.example.roomexample.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomexample.database.Task

@Dao
interface TaskDao {

    //Insertar un objeto en la tabla utilizando suspend de corroutinas
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOneTask(mTask: Task)

    //Insertar multiples objetos Task en la tabla
    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    fun insertMultipleTask(mListTask: List<Task>)

    @Update
    fun updateOneTask(mTask: Task)

    @Delete
    fun deleteOneTask(mTask: Task)

    //Esta funcion devolvera un listado envuelto en LiveDAta
    @Query("SELECT * FROM table_task")
    fun getAllTaskFromDb(): LiveData<List<Task>>

    //Busca un elemento por ID
    @Query("SELECT * FROM TABLE_TASK WHERE id =:mId")
    fun getOneTaskByID(mId: Int): Task
}