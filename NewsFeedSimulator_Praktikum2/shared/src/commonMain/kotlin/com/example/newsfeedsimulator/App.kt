package com.example.newsfeedsimulator


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.safeContentPadding

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope


@Composable
@Preview

fun App() {
    MaterialTheme {

        var latestNews by remember { mutableStateOf<News?>(null) }
        val viewModel = remember { NewsViewModel() }
        val readCount by viewModel.readCount.collectAsState()

        LaunchedEffect(Unit) {
            newsFlow()
                .filter { news ->
                    news.category == "Nasional"
                }
                .map { news ->
                    news.copy(
                        title = "[${news.category}] ${news.title}"
                    )
                }
                .collect { news ->

                    latestNews = news
                    viewModel.newsRead()

                    coroutineScope {
                        val detail = async {
                            getNewsDetail(news)
                        }

                        println(detail.await())
                    }
                }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .safeContentPadding()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "News Feed Simulator",
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = "Berita diproses: $readCount"
            )

            Spacer(modifier = Modifier.height(20.dp))

            latestNews?.let { news ->
                Text(
                    text = news.title,
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Kategori: ${news.category}"
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = news.content
                )
            } ?: Text("Menunggu berita...")
        }
    }
}