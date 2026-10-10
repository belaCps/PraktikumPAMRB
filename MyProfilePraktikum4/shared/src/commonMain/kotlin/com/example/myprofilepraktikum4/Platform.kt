package com.example.myprofilepraktikum4

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform