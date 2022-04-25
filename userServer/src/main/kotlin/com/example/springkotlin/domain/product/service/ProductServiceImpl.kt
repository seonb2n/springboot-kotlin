package com.example.springkotlin.domain.product.service

import com.example.springkotlin.domain.product.ProductCommand
import com.example.springkotlin.domain.product.ProductInfo
import com.example.springkotlin.domain.user.User
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Slf4j
class ProductServiceImpl: ProductService {

    @Autowired
    lateinit var productReader: ProductReader

    @Autowired
    lateinit var productStore: ProductStore

    @Transactional
    override fun addProduct(productAddCommand: ProductCommand.ProductAddCommand): ProductInfo.Main {
        val user = SecurityContextHolder.getContext().authentication.principal as User
        val product = productAddCommand.toEntity(user)
        val productInfo = productStore.storeProduct(product)
        return ProductInfo.Main(productInfo)
    }

    override fun getProductWithProductId(productId: Long): ProductInfo.Main {
        val product = productReader.getProductWithProductId(productId)
        return ProductInfo.Main(product)
    }

    override fun getProductWithUserId(user: User): MutableSet<ProductInfo.Main> {
        val productSet = productReader.getProductsWithUser(user)
        return ProductInfo.makeProductInfoSet(productSet)
    }

    @Transactional
    override fun deleteProductWithProductId(productId: Long) {
        val product = productReader.getProductWithProductId(productId)
        return productStore.deleteProduct(product)
    }
}