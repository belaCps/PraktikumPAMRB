package com.example.myfirstkmpapp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.LaunchedEffect
import org.jetbrains.compose.resources.painterResource
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map

import myfirstkmpapp.shared.generated.resources.Res
import myfirstkmpapp.shared.generated.resources.compose_multiplatform

@Composable
fun App() {
    MaterialTheme {

        var latestNews by remember { mutableStateOf<News?>(null) }

        LaunchedEffect(Unit) {
            newsFlow()
                .filter { it.category == "Nasional" }
                .map { news ->
                    News(
                        title = "${news.title} - ${news.category}",
                        category = news.category,
                        content = news.content
                    )
                }
        }

        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Text("NEWS FEED")

            Text(
                text = latestNews
            )
            }
        }
    }
