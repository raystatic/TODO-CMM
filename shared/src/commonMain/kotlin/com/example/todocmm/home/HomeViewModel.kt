package com.example.todocmm.home

import com.example.todocmm.domain.Todo
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * Created by Rahul Ray.
 * Version 1.0.0 on 11,November,2023
 */
class HomeViewModel: ViewModel() {

    private val defaultTodoList = listOf(
        Todo(
            todo = "Task 1"
        ),
        Todo(
            todo = "Task 2"
        ),
        Todo(
            todo = "Task 3"
        )
    )

    var todoList = MutableStateFlow(defaultTodoList)
        private set

    fun updateTodo(todo: Todo, index: Int) {
        val originalList = todoList.value.toMutableList()
        originalList[index] = todo
        todoList.value = originalList
    }

}