package com.example.myfirstkmpapp

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class NewsFeedManager {
    private val _readCount = MutableStateFlow(0)
    val readCount: StateFlow<Int> = _readCount.asStateFlow()

    fun markAsRead() {
        _readCount.value++
    }

    fun resetReadCount() {
        _readCount.value = 0
    }
}
fun newsFlow(): Flow<News> = flow {

    val newsList = listOf(
        News(
            title = "Presiden Prabowo Menghina Pakar: 'Saking pintarnya jadi goblok' ",
            category = "Politik",
            content = "Presiden Prabowo Subianto menyampaikan pernyataan tersebut saat menghadiri HUT ke-28 PAN di Jakarta pada 18 September 2026."
        ),
        News(
            title = "Tim SAR Terus Cari Korban KM Virgo Transport 8",
            category = "Nasional",
            content = "Tim SAR masih melakukan pencarian terhadap penumpang dan awak kapal KM Virgo Transport 8 yang belum ditemukan."
        ),
        News(
            title = "Kampus Gelar Seminar Nasional",
            category = "Pendidikan",
            content = "Seminar nasional akan diselenggarakan minggu ini."
        ),
        News(
            title = "Perkembangan Teknologi Smartphone",
            category = "Teknologi",
            content = "Teknologi smartphone terus mengalami perkembangan."
        )
    )

    for (news in newsList) {
        delay(2000)
        emit(news)
    }
}