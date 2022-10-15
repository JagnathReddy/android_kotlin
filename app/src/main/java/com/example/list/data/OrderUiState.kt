package com.example.list.data

import com.example.list.student

data class OrderUiState (
    val outList: List<student> = listOf(),

    val pickupOptions: List<String> = listOf()
    )
