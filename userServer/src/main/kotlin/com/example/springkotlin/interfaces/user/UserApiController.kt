package com.example.springkotlin.interfaces.user

import com.example.springkotlin.application.user.UserFacade
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/users")
class UserApiController {

    @Autowired
    private lateinit var userFacade: UserFacade

    @PostMapping("/getuser")
    fun getUser(@RequestBody getWithIdRequest: UserDto.GetWithIdRequest):UserDto.UserResponse {
        val userInfo = userFacade.getUserWithUserId(getWithIdRequest.userId)
        val response = UserDto.UserResponse(userInfo)
        return response
    }

}
