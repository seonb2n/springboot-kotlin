package com.example.springkotlin.infrastructures.user

import com.example.springkotlin.domain.user.User
import com.example.springkotlin.domain.user.service.UserStore
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class UserStoreImpl : UserStore{

    @Autowired
    lateinit var userRepository: UserRepository

    override fun storeUser(user: User): User {
        return userRepository.save(user)
    }
}