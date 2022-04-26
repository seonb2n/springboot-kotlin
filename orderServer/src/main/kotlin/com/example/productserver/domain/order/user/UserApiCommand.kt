package com.example.productserver.domain.order.user

class UserApiCommand {

    class UpdateUserCredit (
        val userToken: String,
        val productToken: String,
        val credit:Int
        ){
    }

}