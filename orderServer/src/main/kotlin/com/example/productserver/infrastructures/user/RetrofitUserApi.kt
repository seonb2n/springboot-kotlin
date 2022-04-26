package com.example.productserver.infrastructures.user

import com.example.productserver.domain.order.user.UserApiCommand
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface RetrofitUserApi {

    @POST
    fun updateUserCredit(@Header("authorization") jwtToken: String, @Body request: UserApiCommand.UpdateUserCredit): Call<RetrofitUserApiResponse>
}