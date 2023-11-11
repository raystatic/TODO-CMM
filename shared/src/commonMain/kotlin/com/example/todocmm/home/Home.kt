package com.example.todocmm.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.todocmm.navigation.CreateScreen

/**
 * Created by Rahul Ray.
 * Version 1.0.0 on 11,November,2023
 */

@Composable
fun Home(
    modifier: Modifier = Modifier,
    navigator: Navigator = LocalNavigator.currentOrThrow
) {

    Box(
        modifier = modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(
                text = "Home",
                style = TextStyle(
                    color = Color.Blue,
                    fontSize = 16.sp
                )
            )
            Spacer(modifier.height(16.dp))
            Button(onClick = {
                navigator.push(CreateScreen)
            }, shape = RoundedCornerShape(4.dp)) {
                Text(
                    text = "Go to Create",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp
                    )
                )
            }
        }
    }
}