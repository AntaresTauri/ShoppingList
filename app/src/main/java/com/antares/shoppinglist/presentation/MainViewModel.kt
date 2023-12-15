package com.antares.shoppinglist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.antares.shoppinglist.data.ShopListRepositoryImpl
import com.antares.shoppinglist.domain.DeleteShopItemUseCase
import com.antares.shoppinglist.domain.EditShopItemUseCase
import com.antares.shoppinglist.domain.GetShopListUseCase
import com.antares.shoppinglist.domain.ShopItem

class MainViewModel : ViewModel() {

    // Создавать переменную репозитория во ВьюМодели неправильно, так как
    // data-слой и presentation-слой не должны знать друг о друге ничего.
    // Правильно можно сделать с помощью внедрения зависимостей.
    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {

        // Создаем копию объекта shopItem с противоположным значением enabled
        val newItem = shopItem.copy(enabled = !shopItem.enabled)

        editShopItemUseCase.editShopItem(newItem)
    }
}