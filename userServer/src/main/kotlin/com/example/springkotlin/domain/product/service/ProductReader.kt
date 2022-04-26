package com.example.springkotlin.domain.product.service

import com.example.springkotlin.domain.product.Product
import com.example.springkotlin.domain.user.User

interface ProductReader {

    fun getProductWithProductId(productId: Long): Product

    fun getProductsWithUser(user: User): MutableSet<Product>

    fun getAllProducts(): MutableList<Product>
}