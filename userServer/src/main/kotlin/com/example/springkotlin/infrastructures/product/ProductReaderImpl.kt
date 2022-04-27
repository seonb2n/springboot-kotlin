package com.example.springkotlin.infrastructures.product

import com.example.springkotlin.domain.product.Product
import com.example.springkotlin.domain.product.service.ProductReader
import com.example.springkotlin.domain.user.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.lang.RuntimeException

@Component
class ProductReaderImpl: ProductReader {

    @Autowired
    lateinit var productRepository: ProductRepository

    override fun getProductWithProductId(productId: Long): Product {
        return productRepository.findProductByProductId(productId) ?: throw RuntimeException("$productId can not found")
    }

    override fun getProductsWithUser(user: User): MutableSet<Product> {
        return productRepository.findProductsByUser(user)
    }

    override fun getAllProducts(): MutableList<Product> {
        return productRepository.findAll()
    }

    override fun getProductWithProductToken(productToken: String): Product {
        return productRepository.findProductByProductToken(productToken) ?: throw RuntimeException("$productToken can not found")
    }
}