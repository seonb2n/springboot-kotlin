package com.example.springkotlin.interfaces.product

import com.example.springkotlin.domain.product.ProductCommand
import com.example.springkotlin.domain.product.ProductInfo
import java.util.*

class ProductDto {

    class AddRequest(
        var productName: String,
        var productCost: Int
    )
    {
        fun toCommand(): ProductCommand.ProductAddCommand {
            return ProductCommand.ProductAddCommand(
                name = productName,
                cost = productCost
            )
        }
    }

    class ProductResponse(productInfo: ProductInfo.Main) {
        val productToken = productInfo.productToken
        val productId = productInfo.productId
        val name = productInfo.name
        val cost = productInfo.cost
        val userId = productInfo.userId
    }

    companion object {
        fun toProductsResponse(productInfoList: MutableList<ProductInfo.Main>): MutableList<ProductResponse> {
            val resultList = mutableListOf<ProductResponse>()
            productInfoList.forEach {
                resultList.add(ProductResponse(it))
            }
            return resultList
        }
    }
}