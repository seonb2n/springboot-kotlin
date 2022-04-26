package com.example.productserver.infrastructures.user

import com.example.productserver.domain.order.user.UserApiCaller
import com.example.productserver.domain.order.user.UserApiCommand
import org.springframework.stereotype.Component

@Component
class UserApiCallerImpl: UserApiCaller {
    override fun updateUserCredit(request: UserApiCommand.UpdateUserCredit): Boolean {
        TODO("Not yet implemented")
    }
}