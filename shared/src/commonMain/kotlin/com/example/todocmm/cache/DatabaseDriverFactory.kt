package com.example.todocmm.cache

import com.squareup.sqldelight.db.SqlDriver

/**
 * Created by Rahul Ray.
 * Version 1.0.0 on 14,November,2023
 */
expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}

expect fun getDatabaseDriverFactory(): DatabaseDriverFactory?