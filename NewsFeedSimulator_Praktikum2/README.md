# News Feed Simulator

## Deskripsi

News Feed Simulator merupakan aplikasi sederhana yang dibuat menggunakan Kotlin untuk mensimulasikan proses pengambilan dan pengolahan berita.

Berita akan muncul secara bertahap dengan jeda 2 detik. Aplikasi hanya menampilkan berita dengan kategori **Nasional** dan menghitung jumlah berita yang sudah diproses.

## Fitur

* Menampilkan berita setiap 2 detik menggunakan `Flow`.
* Memfilter berita berdasarkan kategori.
* Mengubah judul berita menggunakan `map`.
* Menghitung jumlah berita yang diproses menggunakan `StateFlow`.
* Mengambil detail berita menggunakan `async/await`.

## Teknologi

* Kotlin
* Kotlin Coroutines
* Kotlin Flow
* StateFlow
* Compose Multiplatform

## Struktur File

* `News.kt` — berisi data berita seperti judul, kategori, dan isi berita.
* `NewsFeed.kt` — mengatur aliran berita dan proses pengambilan detail berita.
* `NewsViewModel.kt` — mengatur jumlah berita yang sudah diproses.
* `App.kt` — menampilkan berita pada aplikasi.

## Cara Menjalankan

1. Buka project `NewsFeedSimulator` di Android Studio.
2. Tunggu sampai proses Gradle selesai.
3. Hubungkan HP atau jalankan emulator.
4. Pilih `androidApp` sebagai konfigurasi.
5. Klik **Run**.
6. Tunggu beberapa saat sampai berita muncul di aplikasi.

## Alur Program

```text
newsFlow()
   ↓
Berita dikirim setiap 2 detik
   ↓
Filter kategori "Nasional"
   ↓
map untuk mengubah judul
   ↓
collect
   ↓
Jumlah berita dihitung dengan StateFlow
   ↓
Detail berita diproses dengan async/await
```
