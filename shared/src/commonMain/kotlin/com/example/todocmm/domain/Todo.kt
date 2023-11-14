package com.example.todocmm.domain

import kotlinx.datetime.Clock

/**
 * Created by Rahul Ray.
 * Version 1.0.0 on 11,November,2023
 */
data class Todo(
    val id: Long,
    val todo: String? = null,
    var isCompleted: Boolean = false,
    val updateAt: Long = Clock.System.now().toEpochMilliseconds()
)