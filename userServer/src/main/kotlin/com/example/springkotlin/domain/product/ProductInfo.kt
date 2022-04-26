package com.example.springkotlin.domain.product

import java.util.*

class ProductInfo {
    class Main(product: Product) {
        val productToken = product.productToken
        val productId = product.productId
        val name = product.name
        val amount = product.amount
        val cost = product.cost
        val userId = product.user.userId
    }

    companion object {
        fun makeProductInfoList(productList: MutableList<Product>): MutableList<Main> {
            var productInfoList = mutableListOf<Main>()
            productList.forEach {
                productInfoList.add(Main(it))
            }
            return productInfoList
        }
    }

}