package com.example.springkotlin.domain.product.service

import com.example.springkotlin.domain.product.Product
import com.example.springkotlin.domain.product.ProductCommand
import com.example.springkotlin.domain.product.ProductInfo
import com.example.springkotlin.domain.user.User

interface ProductService {

    fun addProduct(productAddCommand: ProductCommand.ProductAddCommand): ProductInfo.Main

    fun getProductWithProductId(productId: Long): ProductInfo.Main

    fun deleteProductWithProductId(productId: Long)

    fun getAllProducts(): MutableList<ProductInfo.Main>

    fun getProductWithProductToken(productToken: String): ProductInfo.Main
}