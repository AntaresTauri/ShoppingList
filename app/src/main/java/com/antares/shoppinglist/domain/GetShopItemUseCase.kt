package com.antares.shoppinglist.domain

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {

    // Получаем ShopItem
    fun getShopItem(shopItemId: Int): ShopItem {
        return shopListRepository.getShopItem(shopItemId)
    }
}