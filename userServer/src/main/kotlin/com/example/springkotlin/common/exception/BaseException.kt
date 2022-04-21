package com.example.springkotlin.common.exception

import java.lang.RuntimeException
import com.example.springkotlin.common.response.ErrorCode

class BaseException : RuntimeException {
    var errorCode: ErrorCode? = null

    constructor() {}
    constructor(errorCode: ErrorCode) : super(errorCode.getErrorMsg()) {
        this.errorCode = errorCode
    }

    constructor(message: String?, errorCode: ErrorCode?) : super(message) {
        this.errorCode = errorCode
    }

    constructor(message: String?, errorCode: ErrorCode?, cause: Throwable?) : super(message, cause) {
        this.errorCode = errorCode
    }
}