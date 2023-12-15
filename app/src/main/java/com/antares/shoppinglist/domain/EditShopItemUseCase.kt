package com.antares.shoppinglist.domain

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {

    // Редактируем элемент
    fun editShopItem(shopItem: ShopItem) {
        shopListRepository.editShopItem(shopItem)
    }
}