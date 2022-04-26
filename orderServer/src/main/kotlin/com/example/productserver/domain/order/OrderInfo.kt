package com.example.productserver.domain.order

class OrderInfo {

    class Main(order: Order) {
        val orderToken = order.orderToken
        val userToken = order.userToken
        val productToken = order.productToken
    }

}