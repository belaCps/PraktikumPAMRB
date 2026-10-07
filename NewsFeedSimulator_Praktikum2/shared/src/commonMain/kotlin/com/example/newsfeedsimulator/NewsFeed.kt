package com.example.newsfeedsimulator

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

fun newsFlow(): Flow<News> = flow {

    val newsList = listOf(
        News(
            title = "Tim SAR Terus Cari Korban KM Virgo Transport 8",
            category = "Nasional",
            content = "Tim SAR masih melakukan pencarian terhadap penumpang dan awak kapal KM Virgo Transport 8."
        ),
        News(
            title = "Perkembangan Pendidikan di Indonesia",
            category = "Pendidikan",
            content = "Berbagai program pendidikan terus dikembangkan untuk mendukung proses pembelajaran."
        ),
        News(
            title = "Perkembangan Teknologi Smartphone",
            category = "Teknologi",
            content = "Teknologi smartphone terus mengalami perkembangan dengan berbagai fitur baru."
        )
    )

    for (news in newsList) {
        delay(2000)
        emit(news)
    }
}

suspend fun getNewsDetail(news: News): String {
    return withContext(Dispatchers.Default) {
        delay(1000)
        "Detail: ${news.content}"
    }
}