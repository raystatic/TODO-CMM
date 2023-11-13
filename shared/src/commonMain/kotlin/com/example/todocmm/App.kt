package com.example.todocmm

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.example.todocmm.navigation.HomeScreen

@Composable
fun App() {
    Navigator(HomeScreen)
}

