package com.example.todocmm.utils

import android.content.Context
import java.lang.ref.WeakReference

/**
 * Created by Rahul Ray.
 * Version 1.0.0 on 14,November,2023
 */
actual object AppContext {
    private var value: WeakReference<Context?>? = null

    fun set(context: Context) {
        value = WeakReference(context)
    }

    internal fun get(): Context? {
        return value?.get()
    }

}