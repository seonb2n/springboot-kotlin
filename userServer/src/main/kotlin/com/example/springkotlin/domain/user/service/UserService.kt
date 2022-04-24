package com.example.springkotlin.domain.user.service

import com.example.springkotlin.domain.user.UserCommand
import com.example.springkotlin.domain.user.UserInfo
import org.springframework.security.core.userdetails.UserDetailsService

interface UserService : UserDetailsService{

    fun registerUser(registerUser: UserCommand.UserRegisterCommand): UserInfo.Main

    fun getUserWithUserId(userId: Long): UserInfo.Main

    fun getUserWithUserNickName(userNickName: String): UserInfo.Main

    fun isUserExist(userNickName: String): Boolean
}