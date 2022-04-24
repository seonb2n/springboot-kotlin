package com.example.springkotlin.infrastructure.product

import com.example.springkotlin.domain.product.Product
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProductRepository: JpaRepository<Product, Long> {

    fun findProductByProductId(productId: Long): Product
    fun findProductsByUserId(userId: Long): TreeSet<Product>
}