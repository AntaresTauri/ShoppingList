package com.antares.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.antares.shoppinglist.domain.ShopItem
import com.antares.shoppinglist.domain.ShopListRepository

// Объект ShopListRepositoryImpl будет всегда один и тот же
object ShopListRepositoryImpl : ShopListRepository {

    private val shopListLD = MutableLiveData<List<ShopItem>>()
    private val shopList = mutableListOf<ShopItem>()

    // Переменная хранит id элементов
    private var autoIncrementId = 0

    init {
        for (i in 0 until 10) {
            val item = ShopItem("Name $i", i, true)
            addShopItem(item)
        }
    }

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
        updateList()
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    // Удаляем старый объект и вставляем новый. Сначала нужно найти
    // старый элемент по его id, удалить, а затем добавить новый
    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
    }

    // Ищем элемент по id и возвращаем его
    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find {
            it.id == shopItemId
        } ?: throw RuntimeException("Element with id $shopItemId not found")
    }

    // Возвращаем shopList типа LiveData
    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }

    // Метод обновляет переменную shopListLD. Для безопасности присваиваем
    // копию shopList
    private fun updateList() {
        shopListLD.value = shopList.toList()
    }
}