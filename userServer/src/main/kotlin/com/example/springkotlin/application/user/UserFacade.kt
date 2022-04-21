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

    fun registerUser(registerUser: UserCommand.RegisterUser): UserInfo.Main {
        val userInfo = userService.registerUser(registerUser)
        return userInfo
    }

    fun getUser(userId: Long): UserInfo.Main {
        val userInfo = userService.getUserWithUserId(userId)
        return userInfo
    }

}