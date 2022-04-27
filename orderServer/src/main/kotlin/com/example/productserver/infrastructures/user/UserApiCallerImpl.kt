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

    override fun updateUserCredit(jwtToken: String, request: UserApiCommand.UpdateUserCredit): Boolean {
        val call = retrofitUserApi.updateUserCredit(jwtToken, request)
        var response: Response<RetrofitUserApiResponse.Update> = call.execute()
        if(response.body()?.isUpdated == true) {
            return true
        }
        return false
    }
}