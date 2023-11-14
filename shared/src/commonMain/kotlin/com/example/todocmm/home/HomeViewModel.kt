package com.example.todocmm.home

import com.example.todocmm.data.Repository
import com.example.todocmm.domain.Todo
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

/**
 * Created by Rahul Ray.
 * Version 1.0.0 on 11,November,2023
 */
class HomeViewModel: ViewModel() {

    private val repository = Repository()

    private val defaultTodoList = listOf(
        Todo(
            id = 0,
            todo = "Task 1"
        ),
        Todo(
            id = 1,
            todo = "Task 2"
        ),
        Todo(
            id = 2,
            todo = "Task 3"
        )
    )

    init {
        insertDefaultTodos()
    }

    var todoList = MutableStateFlow(repository.getTodos())
        private set

    private fun insertDefaultTodos() = viewModelScope.launch {
        val oldData = repository.getTodos()
        defaultTodoList.forEach { todo ->
            if (oldData?.find { it.id == todo.id } == null) {
                repository.createTodo(todo)
            }
        }
        todoList.value = repository.getTodos()
    }

    fun updateTodo(todo: Todo) = viewModelScope.launch{
        repository.updateTodo(todo)
        todoList.value = repository.getTodos()
    }

}