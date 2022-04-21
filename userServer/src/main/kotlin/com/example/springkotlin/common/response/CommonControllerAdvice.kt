package com.example.springkotlin.common.response

import lombok.extern.slf4j.Slf4j
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.http.HttpStatus
import com.example.springkotlin.common.response.CommonResponse
import com.example.springkotlin.common.response.ErrorCode
import com.example.springkotlin.common.exception.BaseException
import com.google.common.collect.Lists
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.Exception

@Slf4j
@ControllerAdvice
class CommonControllerAdvice {
    /**
     * http status: 500 AND result: FAIL
     * 시스템 예외 상황. 집중 모니터링 대상
     *
     * @param e
     * @return
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = [Exception::class])
    fun onException(e: Exception?): CommonResponse<Any> {
        return CommonResponse.fail(ErrorCode.COMMON_SYSTEM_ERROR)
    }

    /**
     * http status: 200 AND result: FAIL
     * 시스템은 이슈 없고, 비즈니스 로직 처리에서 에러가 발생함
     *
     * @param e
     * @return
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = [BaseException::class])
    fun onBaseException(e: BaseException): CommonResponse<Any> {
        return CommonResponse.fail(e.message, e.errorCode?.name)
    }

    /**
     * http status: 400 AND result: FAIL
     * request parameter 에러
     *
     * @param e
     * @return
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = [MethodArgumentNotValidException::class])
    fun methodArgumentNotValidException(e: MethodArgumentNotValidException): CommonResponse<Any> {
        val bindingResult = e.bindingResult
        val fe = bindingResult.fieldError
        return if (fe != null) {
            val message = "Request Error" + " " + fe.field + "=" + fe.rejectedValue + " (" + fe.defaultMessage + ")"
            CommonResponse.fail(message, ErrorCode.COMMON_INVALID_PARAMETER.name)
        } else {
            CommonResponse.fail(
                ErrorCode.COMMON_INVALID_PARAMETER.getErrorMsg(),
                ErrorCode.COMMON_INVALID_PARAMETER.name
            )
        }
    }

    companion object {
        private val SPECIFIC_ALERT_TARGET_ERROR_CODE_LIST: List<ErrorCode> = Lists.newArrayList()
    }
}