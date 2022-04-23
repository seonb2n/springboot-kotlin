package com.example.springkotlin.interfaces.user

import com.example.springkotlin.application.user.UserFacade
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserRegisterController {

    @Autowired
    private lateinit var userFacade: UserFacade

    @PostMapping("/register")
    fun registerUser(@RequestBody registerRequest: UserDto.RegisterRequest): UserDto.UserResponse {
        if (userFacade.isUserExist(registerRequest.userNickName)) {
            throw RuntimeException("userNickName already exist")
        }
        val userCommand = registerRequest.toCommand()
        val userInfo = userFacade.registerUser(userCommand)
        return UserDto.UserResponse(userInfo)

    }
}