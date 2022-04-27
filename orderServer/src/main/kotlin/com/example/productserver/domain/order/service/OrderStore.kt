package com.example.productserver.domain.order.service

import com.example.productserver.domain.order.ProductOrder

interface OrderStore {

    fun storeOrder(order: ProductOrder): ProductOrder
}