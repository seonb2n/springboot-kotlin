package com.example.springkotlin.domain.user.service

import com.example.springkotlin.domain.user.User

interface UserReader {

    fun getUserWithUserId(userId: Long) : User
    fun getUserWithUserNickName(userNickName: String) : User
    fun isUserExist(userNickName: String) : Boolean
}