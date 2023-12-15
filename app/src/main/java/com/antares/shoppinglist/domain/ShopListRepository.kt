package com.antares.shoppinglist.domain

import androidx.lifecycle.LiveData

// Интерфейс репозитория. Этот репозиторий должен уметь делать все,
// что требуется нашим UseCase
interface ShopListRepository {

    fun addShopItem(shopItem: ShopItem)

    fun deleteShopItem(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)

    fun getShopItem(shopItemId: Int): ShopItem

    fun getShopList(): LiveData<List<ShopItem>>
}