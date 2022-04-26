package com.example.springkotlin.application.product

import com.example.springkotlin.domain.product.ProductCommand
import com.example.springkotlin.domain.product.ProductInfo
import com.example.springkotlin.domain.product.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductFacade {
    @Autowired
    lateinit var productService: ProductService

    fun addProduct(addProduct: ProductCommand.ProductAddCommand): ProductInfo.Main {
        return productService.addProduct(addProduct)
    }

    fun deleteProduct(productIdCommand: ProductCommand.ProductIdCommand) {
        val productId = productIdCommand.productId
          return productService.deleteProductWithProductId(productId)
    }

    fun getAllProducts(): MutableList<ProductInfo.Main> {
        return productService.getAllProducts()
    }
}