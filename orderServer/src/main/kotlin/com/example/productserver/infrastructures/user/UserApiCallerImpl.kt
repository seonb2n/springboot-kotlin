package com.example.productserver.infrastructures.user

import com.example.productserver.domain.order.user.UserApiCaller
import com.example.productserver.domain.order.user.UserApiCommand
import com.example.productserver.infrastructures.retrofit.RetrofitUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import retrofit2.Response

@Component
class UserApiCallerImpl: UserApiCaller {

    @Autowired
    lateinit var retrofitUtils: RetrofitUtils

    @Autowired
    lateinit var retrofitUserApi: RetrofitUserApi

    override fun updateUserCredit(jwtToken: String, request: UserApiCommand.UpdateUserCredit) {
        val call = retrofitUserApi.updateUserCredit(jwtToken, request)
        call.execute()
    }
}