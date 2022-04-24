package com.example.springkotlin.infrastructure.product

import com.example.springkotlin.domain.product.Product
import com.example.springkotlin.domain.product.service.ProductReader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ProductReaderImpl: ProductReader {

    @Autowired
    lateinit var productRepository: ProductRepository

    override fun getProductWithProductId(productId: Long): Product {
        return productRepository.findProductByProductId(productId)
    }

    override fun getProductsWithUserId(userId: Long): MutableSet<Product> {
        return productRepository.findProductsByUserId(userId)
    }
}