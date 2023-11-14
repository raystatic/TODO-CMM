package com.example.todocmm.data

import com.example.todocmm.cache.Database
import com.example.todocmm.cache.TODO
import com.example.todocmm.cache.getDatabaseDriverFactory
import com.example.todocmm.domain.Todo

/**
 * Created by Rahul Ray.
 * Version 1.0.0 on 14,November,2023
 */
class Repository {

    private val databaseFactory = getDatabaseDriverFactory()
    private val database = Database(databaseFactory)

    suspend fun createTodo(todo: Todo) {
        database.createTodo(todo.toTODO())
    }

    suspend fun updateTodo(todo: Todo) {
        database.updateTodo(todo.toTODO())
    }

    suspend fun removeTodo(todo: Todo) {
        database.removeTodo(todo.toTODO())
    }

    suspend fun removeAllTodos() {
        database.removeAllTodos()
    }

    fun getTodos() = database.getAllTodos()?.map { it.toTodo() }

}

fun Todo.toTODO(): TODO {
    return TODO(
        id = this.id,
        todo = this.todo.toString(),
        isCompleted = this.isCompleted,
        updateAt = this.updateAt
    )
}

fun TODO.toTodo(): Todo {
    return Todo(
        id = this.id,
        todo = this.todo,
        isCompleted = this.isCompleted == true,
        updateAt = this.updateAt
    )
}