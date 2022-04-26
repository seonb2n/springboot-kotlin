package com.example.springkotlin.interfaces.product

import com.example.springkotlin.application.product.ProductFacade
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductGetAllController {

    @Autowired
    lateinit var productFacade: ProductFacade

    @GetMapping("/getproducts")
    fun getAllProducts(): MutableList<ProductDto.ProductResponse> {
        val productInfoList = productFacade.getAllProducts()
        return ProductDto.toProductsResponse(productInfoList)
    }

}