package com.example.productserver.infrastructures.retrofit

import com.example.productserver.infrastructures.user.RetrofitUserApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RetrofitServiceRegistry {

    val baseUrl: String = "http://localhost:8080/"

    @Bean
    fun retrofitUserApi(): RetrofitUserApi {
        val retrofit = RetrofitUtils.initRetrofit(baseUrl)
        return retrofit.create(RetrofitUserApi::class.java)
    }

}