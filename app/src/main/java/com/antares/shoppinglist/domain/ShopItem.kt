package com.antares.shoppinglist.domain

// Класс данных
data class ShopItem(
    val id: Int,
    val name: String,
    val count: Int,
    val enabled: Boolean
)
