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

    private val defaultTodoList = mutableListOf<Todo>()

    init {
        insertDefaultTodos()
    }

    var incompleteTodoList = MutableStateFlow(repository.getInCompletedTodos())
        private set

    var completedTodoList = MutableStateFlow(repository.getCompletedTodos())
        private set

    private fun insertDefaultTodos() = viewModelScope.launch {
        val oldData = repository.getTodos()
        for (i in 0 until 5) {
            defaultTodoList.add(
                Todo(
                    id = i.toLong(),
                    todo = "Task ${i + 1}"
                )
            )
        }
        defaultTodoList.forEach { todo ->
            if (oldData?.find { it.id == todo.id } == null) {
                repository.createTodo(todo)
            }
        }
        incompleteTodoList.value = repository.getInCompletedTodos()
        completedTodoList.value = repository.getCompletedTodos()
    }

    fun updateTodo(todo: Todo) = viewModelScope.launch{
        repository.updateTodo(todo)
        incompleteTodoList.value = repository.getInCompletedTodos()
        completedTodoList.value = repository.getCompletedTodos()
    }

}