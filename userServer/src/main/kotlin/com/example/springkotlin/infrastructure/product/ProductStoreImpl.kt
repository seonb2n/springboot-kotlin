package com.example.springkotlin.infrastructure.product

import com.example.springkotlin.domain.product.Product
import com.example.springkotlin.domain.product.service.ProductStore
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ProductStoreImpl: ProductStore {

    @Autowired
    lateinit var productRepository: ProductRepository

    override fun storeProduct(product: Product): Product {
        return productRepository.save(product)
    }

    override fun deleteProduct(product: Product) {
        return productRepository.delete(product)
    }
}