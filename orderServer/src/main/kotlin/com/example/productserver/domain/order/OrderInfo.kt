package com.example.productserver.domain.order

class OrderInfo {

    class Main(order: ProductOrder) {
        val orderToken = order.orderToken
        val userToken = order.userToken
        val productToken = order.productToken
        val isOrderCompleted = order.isOrderCompleted
    }

}