package com.example.todocmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform