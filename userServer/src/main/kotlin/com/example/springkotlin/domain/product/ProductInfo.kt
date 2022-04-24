package com.example.springkotlin.domain.product

import java.util.*

class ProductInfo {
    class Main(product: Product) {
        val productId = product.productId
        val name = product.name
        val amount = product.amount
        val cost = product.cost
        val userId = product.user.userId
    }

    companion object {
        fun makeProductInfoSet(productSet: MutableSet<Product>): MutableSet<Main> {
            val resultSet = TreeSet<Main>()
            productSet.forEach {
                resultSet.add(Main(it))
            }
            return resultSet
        }
    }

}