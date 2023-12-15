package com.antares.shoppinglist.domain

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {

    // Добавляем элемент в список
    fun addShopItem(shopItem: ShopItem) {
        shopListRepository.addShopItem(shopItem)
    }
}