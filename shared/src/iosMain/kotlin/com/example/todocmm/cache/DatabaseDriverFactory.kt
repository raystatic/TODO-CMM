package com.example.todocmm.cache

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

/**
 * Created by Rahul Ray.
 * Version 1.0.0 on 14,November,2023
 */
actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(AppDatabase.Schema, "todo.db")
    }
}

actual fun getDatabaseDriverFactory(): DatabaseDriverFactory? {
    return DatabaseDriverFactory()
}
