package com.example.myprofilepraktikum4.viewmodel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class ProfileUiState(
    val name: String = "Bela Citra Permata Sari",
    val bio: String = "Mahasiswa Teknik Informatika",
    val isDarkMode: Boolean = false,
    val isEditing: Boolean = false
)

class ProfileViewModel {

    private val _uiState = MutableStateFlow(ProfileUiState())

    val uiState: StateFlow<ProfileUiState> =
        _uiState.asStateFlow()

    fun updateName(name: String) {
        _uiState.value = _uiState.value.copy(name = name)
    }

    fun updateBio(bio: String) {
        _uiState.value = _uiState.value.copy(bio = bio)
    }

    fun setEditing(isEditing: Boolean) {
        _uiState.value = _uiState.value.copy(
            isEditing = isEditing
        )
    }

    fun toggleDarkMode(isDarkMode: Boolean) {
        _uiState.value = _uiState.value.copy(
            isDarkMode = isDarkMode
        )
    }
}