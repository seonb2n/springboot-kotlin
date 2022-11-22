package com.example.springkotlin.domain.user

/**
 * 최적화가 되는 객체 클래스
 * https://velog.io/@dhwlddjgmanf/Kotlin-1.5%EC%97%90-%EC%B6%94%EA%B0%80%EB%90%9C-value-class%EC%97%90-%EB%8C%80%ED%95%B4-%EC%95%8C%EC%95%84%EB%B3%B4%EC%9E%90
 */
@JvmInline
value class UserId(val id: Long) {
}
