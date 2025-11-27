package com.example.a086_roomdatabase.viewmodel

import androidx.lifecycle.ViewModel
import com.example.a086_roomdatabase.repositori.RepositoriSiswa

class HomeViewModel(private val repositori: RepositoriSiswa): ViewModel() {

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}