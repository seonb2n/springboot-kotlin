package com.example.springkotlin.interfaces.user

import com.example.springkotlin.application.user.UserFacade
import com.example.springkotlin.config.security.JwtTokenProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserLoginController {

    @Autowired
    private lateinit var userFacade: UserFacade
    @Autowired
    private lateinit var jwtTokenProvider: JwtTokenProvider

    @PostMapping("/login")
    fun registerUser(@RequestBody loginRequest: UserDto.LoginRequest): UserDto.UserLogInResponse {
        val user = userFacade.getUserWithUserNickName(userNickName = loginRequest.userNickName)
        if(loginRequest.userPassword != user.userPassword) {
            throw RuntimeException("User Password is Wrong")
        }
        val userToken = jwtTokenProvider.createToken(user.userNickName)
        return UserDto.UserLogInResponse(user, userToken)
    }

}