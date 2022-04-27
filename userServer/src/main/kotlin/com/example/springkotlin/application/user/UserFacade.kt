package com.example.springkotlin.application.user

import com.example.springkotlin.domain.user.UserCommand
import com.example.springkotlin.domain.user.UserInfo
import com.example.springkotlin.domain.user.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserFacade {

    @Autowired
    lateinit var userService: UserService

    fun registerUser(registerUser: UserCommand.UserRegisterCommand): UserInfo.Main {
        return userService.registerUser(registerUser)
    }

    fun getUserWithUserId(userId: Long): UserInfo.Main {
        return userService.getUserWithUserId(userId)
    }

    fun getUserWithUserNickName(userNickName: String): UserInfo.Main {
        return userService.getUserWithUserNickName(userNickName)
    }

    fun isUserExist(userNickName: String): Boolean {
        return userService.isUserExist(userNickName)
    }

    fun updateUserCredit(userToken: String, productToken: String): Boolean {
        return userService.updateUserCredit(userToken, productToken)
    }

}