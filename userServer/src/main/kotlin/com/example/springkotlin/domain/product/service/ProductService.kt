package com.example.springkotlin.domain.product.service

import com.example.springkotlin.domain.product.Product
import com.example.springkotlin.domain.product.ProductCommand
import com.example.springkotlin.domain.product.ProductInfo

interface ProductService {

    fun addProduct(productAddCommand: ProductCommand.ProductAddCommand): ProductInfo.Main

    fun getProductWithProductId(productId: Long): ProductInfo.Main

    fun getProductWithUserId(userId: Long): MutableSet<ProductInfo.Main>

    fun deleteProductWithProductId(productId: Long)
}