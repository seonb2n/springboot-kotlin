package com.example.springkotlin.infrastructure.product

import com.example.springkotlin.domain.product.Product
import com.example.springkotlin.domain.product.service.ProductReader
import com.example.springkotlin.domain.user.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ProductReaderImpl: ProductReader {

    @Autowired
    lateinit var productRepository: ProductRepository

    override fun getProductWithProductId(productId: Long): Product {
        return productRepository.findProductByProductId(productId)
    }

    override fun getProductsWithUser(user: User): MutableSet<Product> {
        return productRepository.findProductsByUser(user)
    }

    override fun getAllProducts(): MutableList<Product> {
        return productRepository.findAll()
    }
}