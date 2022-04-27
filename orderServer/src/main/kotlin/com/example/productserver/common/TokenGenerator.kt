package com.example.productserver.common

import org.apache.commons.lang3.RandomStringUtils

class TokenGenerator {

    companion object {
        private fun randomCharacter(length: Int): String {
            return RandomStringUtils.randomAlphanumeric(length)
        }

        fun randomCharacterWithPrefix(prefix: String): String {
            val tokenLength: Int = 20
            return prefix + randomCharacter(tokenLength - prefix.length)
        }
    }

}