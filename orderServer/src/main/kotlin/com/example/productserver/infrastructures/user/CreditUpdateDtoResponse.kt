package com.example.productserver.infrastructures.user

class CreditUpdateDtoResponse {

    class Update(
        val isUpdated: Boolean,
        val productToken: String,
        val orderToken: String
    )

}