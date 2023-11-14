package com.example.todocmm.cache

import android.content.Context
import androidx.compose.ui.platform.LocalContext
import com.example.todocmm.utils.AppContext
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

/**
 * Created by Rahul Ray.
 * Version 1.0.0 on 14,November,2023
 */
actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(AppDatabase.Schema, context, "todo.db")
    }

}

actual fun getDatabaseDriverFactory(): DatabaseDriverFactory? {
    AppContext.get()?.let {
        return DatabaseDriverFactory(it)
    } ?: run {
        return null
    }
}

