package com.example.springkotlin.domain.user.service

import com.example.springkotlin.domain.user.UserCommand
import com.example.springkotlin.domain.user.UserInfo

interface UserService {

    fun registerUser(registerUser: UserCommand.RegisterUser): UserInfo.Main

    fun getUserWithUserId(userId: Long): UserInfo.Main

}