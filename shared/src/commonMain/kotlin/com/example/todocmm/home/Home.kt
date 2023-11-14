package com.example.todocmm.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.todocmm.domain.Todo
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory

/**
 * Created by Rahul Ray.
 * Version 1.0.0 on 11,November,2023
 */

@Composable
fun Home(
    modifier: Modifier = Modifier,
    navigator: Navigator = LocalNavigator.currentOrThrow
) {

    val viewModel = getViewModel(
        key = HomeViewModel::class.simpleName.toString(),
        factory = viewModelFactory { HomeViewModel() }
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "TODO CMM",
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            )
        }

        Spacer(modifier.height(20.dp))

        val incompleteTodos = viewModel.incompleteTodoList.collectAsState().value ?: listOf()
        val completedTodos = viewModel.completedTodoList.collectAsState().value ?: listOf()

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            if (incompleteTodos.isNotEmpty()) {
                item {
                    Text(
                        text = "Pending Tasks",
                        style = TextStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp
                        )
                    )
                }

                itemsIndexed(incompleteTodos) { index, item ->
                    TodoView(modifier, item) {
                        val updatedTodo = incompleteTodos[index].copy(isCompleted = it)
                        viewModel.updateTodo(updatedTodo)
                    }
                }
            }

            if (completedTodos.isNotEmpty()) {
                item {
                    Text(
                        text = "Completed",
                        style = TextStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp
                        )
                    )
                }

                itemsIndexed(completedTodos) { index, item ->
                    TodoView(modifier, item) {
                        val updatedTodo = completedTodos[index].copy(isCompleted = it)
                        viewModel.updateTodo(updatedTodo)
                    }
                }
            }
        }
    }
}

@Composable
fun TodoView(
    modifier: Modifier = Modifier,
    todo: Todo,
    onTaskToggled: (Boolean) -> Unit
) {
    val bgColor = if (todo.isCompleted) {
        0xFFF9F6FF
    } else {
        0xFFFFF2E2
    }

    val borderColor = if (todo.isCompleted) {
        0XFFB887FE
    } else {
        0XFFFEC274
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(bgColor))
            .border(width = 1.dp, color = Color(borderColor), shape = RoundedCornerShape(8.dp)),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Checkbox(checked = todo.isCompleted, onCheckedChange = {
            onTaskToggled(it)
        }, modifier = modifier.padding(8.dp))

        Text(
            text = todo.todo ?: "",
            style = TextStyle(
                color = if (todo.isCompleted) Color.Gray else Color.Black,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                textDecoration = if (todo.isCompleted) TextDecoration.LineThrough else TextDecoration.None
            )
        )
    }
}