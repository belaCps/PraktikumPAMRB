package com.example.newsfeedsimulator

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class NewsViewModel {

    private val _readCount = MutableStateFlow(0)

    val readCount: StateFlow<Int> = _readCount.asStateFlow()

    fun newsRead() {
        _readCount.value++
    }
}