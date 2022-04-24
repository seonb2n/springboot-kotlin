package com.example.springkotlin.domain.product.service

import com.example.springkotlin.domain.product.Product
import com.example.springkotlin.domain.user.User

interface ProductStore {

    fun storeProduct(product: Product): Product

    fun deleteProduct(product: Product)
}