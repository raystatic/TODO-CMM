package com.example.todocmm.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.example.todocmm.create.Create
import com.example.todocmm.home.Home

/**
 * Created by Rahul Ray.
 * Version 1.0.0 on 11,November,2023
 */
object HomeScreen: Screen {

    @Composable
    override fun Content() {
        Home()
    }
}