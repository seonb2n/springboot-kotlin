package com.example.springkotlin.common.exception

import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Slf4j
@Component
class BaseException: RuntimeException() {

    private val log = LoggerFactory.getLogger(javaClass)

    fun entityNotFound(message: String) {
        log.info("$message 를 가진 사용자는 없습니다.")
    }

}