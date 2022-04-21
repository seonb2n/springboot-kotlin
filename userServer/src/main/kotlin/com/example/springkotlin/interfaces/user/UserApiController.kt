package com.example.springkotlin.interfaces.user

import com.example.springkotlin.application.user.UserFacade
import com.example.springkotlin.common.response.CommonResponse
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

    @PostMapping("/register")
    fun registerUser(@RequestBody registerRequest: UserDto.RegisterRequest): CommonResponse<Any> {
        val userCommand = registerRequest.toCommand()
        val userInfo = userFacade.registerUser(userCommand)
        val response = UserDto.UserResponse(
            userId = userInfo.userId,
            userCredit = userInfo.userCredit,
            userNickName = userInfo.userNickName,
            productSet = userInfo.userProductSet
        )
        return CommonResponse.success(response)
    }

    @PostMapping("/getuser")
    fun getUser(@RequestBody getWithIdRequest: UserDto.GetWithIdRequest): CommonResponse<Any> {
        val userInfo = userFacade.getUser(getWithIdRequest.userId)
        val response = UserDto.UserResponse(
            userId = userInfo.userId,
            userCredit = userInfo.userCredit,
            userNickName = userInfo.userNickName,
            productSet = userInfo.userProductSet
        )
        return CommonResponse.success(response)
    }

}
