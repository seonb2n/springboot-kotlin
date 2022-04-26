package com.example.productserver.domain.order.user

interface UserApiCaller {

    //구매한 사용자의 credit 을 감소시키고, product 의 주인의 credit 을 증가시킨다.
    fun updateUserCredit(request: UserApiCommand.UpdateUserCredit): Boolean

}