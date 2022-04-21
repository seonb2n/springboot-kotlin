package com.example.springkotlin.common.response

import lombok.NoArgsConstructor
import lombok.AllArgsConstructor
import com.example.springkotlin.common.response.CommonResponse
import com.example.springkotlin.common.response.ErrorCode

/**
 * 응답 결과를 wrap 해서 보내줄 commonResponse class
 */

@NoArgsConstructor
@AllArgsConstructor
class CommonResponse<T>(
    private val result: Result,
    private val data: T? = null,
    private val message: String? = null,
    private val errorCode: String? = null

) {

    enum class Result {
        SUCCESS, FAIL
    }

    companion object {
        fun <T>success(data: T?, message: String?) : CommonResponse<T> {
            return CommonResponse(
                result = Result.SUCCESS,
                data = data,
                message = message
            )
        }

        fun <T>success(data: T?) : CommonResponse<T> {
            return success(data, null)
        }

        fun <T>fail(message: String?, errorCode: String?) : CommonResponse<T> {
            return CommonResponse(
                result = Result.FAIL,
                message = message,
                errorCode = errorCode
            )
        }

        fun <T>fail(errorCode: ErrorCode) : CommonResponse<T> {
            return CommonResponse(
                result = Result.FAIL,
                message = errorCode.getErrorMsg(),
                errorCode = errorCode.name
            )
        }

    }



}