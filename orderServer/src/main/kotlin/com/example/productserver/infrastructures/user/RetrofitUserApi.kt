package com.example.productserver.infrastructures.user

import com.example.productserver.domain.order.user.UserApiCommand
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface RetrofitUserApi {

    @POST("api/v1/users/update/credit")
    fun updateUserCredit(@Header("Authorization") jwtToken: String, @Body request: UserApiCommand.UpdateUserCredit): Call<Void>
}