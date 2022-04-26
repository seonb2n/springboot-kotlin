package com.example.springkotlin.interfaces.product

import com.example.springkotlin.application.product.ProductFacade
import lombok.Getter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/products")
class ProductApiController {

    @Autowired
    lateinit var productFacade: ProductFacade


    @PostMapping("/addproducts")
    fun addProduct(@RequestBody addRequest: ProductDto.AddRequest): ProductDto.ProductResponse {
        val productCommand = addRequest.toCommand()
        val productInfo = productFacade.addProduct(productCommand)
        return ProductDto.ProductResponse(productInfo)
    }
}