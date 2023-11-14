package com.example.todocmm.cache

/**
 * Created by Rahul Ray.
 * Version 1.0.0 on 14,November,2023
 */
internal class Database(databaseDriverFactory: DatabaseDriverFactory?) {

    private var database: AppDatabase? = null
    init {
        databaseDriverFactory?.let {
            database = AppDatabase(it.createDriver())
        }
    }
    private val query = database?.appDatabaseQueries

    internal fun removeAllTodos() {
        query?.transaction {
            query.removeAllTODOs()
        }
    }

    internal fun createTodo(todo: TODO) {
        query?.transaction {
            query.insertTodo(
                id = todo.id,
                todo = todo.todo,
                isCompleted = todo.isCompleted,
                updateAt = todo.updateAt
            )
        }
    }

    internal fun updateTodo(todo: TODO) {
        query?.transaction {
            query.updateTODO(
                id = todo.id,
                todo = todo.todo,
                isCompleted = todo.isCompleted,
                updateAt = todo.updateAt,
            )
        }
    }

    internal fun removeTodo(todo: TODO) {
        query?.transaction {
            query.removeTODO(
                id = todo.id
            )
        }
    }

    internal fun getAllTodos(): List<TODO>? {
        return query?.getAll()?.executeAsList()?.sortedByDescending { it.updateAt }
    }

}