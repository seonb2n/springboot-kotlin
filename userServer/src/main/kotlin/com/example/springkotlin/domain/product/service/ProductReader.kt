package com.example.springkotlin.domain.product.service

import com.example.springkotlin.domain.product.Product

interface ProductReader {

    fun getProductWithProductId(productId: Long): Product

    fun getProductsWithUserId(userId: Long): MutableSet<Product>
}