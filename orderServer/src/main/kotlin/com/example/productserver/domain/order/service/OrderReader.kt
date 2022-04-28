package com.example.productserver.domain.order.service

import com.example.productserver.domain.order.ProductOrder

interface OrderReader {

    fun getOrderWithOrderToken(orderToken: String): ProductOrder

}