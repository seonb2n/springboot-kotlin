package com.example.springkotlin.domain.user.service

import com.example.springkotlin.domain.user.User

interface UserStore {

    fun storeUser(user: User): User

}