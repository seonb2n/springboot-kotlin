package com.example.springkotlin.domain.user

import com.example.springkotlin.config.common.TokenGenerator
import com.example.springkotlin.domain.BaseEntity
import com.example.springkotlin.domain.product.Product
import com.fasterxml.jackson.annotation.JsonManagedReference
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import javax.persistence.*

@Entity
@Table(name="users")
class User (

        @Transient
    private val USER_PREFIX: String = "user_",

        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: Long? = null,
        var userToken: String = TokenGenerator.randomCharacterWithPrefix(USER_PREFIX),
        var nickName: String,
        var userPassword: String,
        var credit: Int,
        @OneToMany(mappedBy = "user")
    @JsonManagedReference
    var productSet: MutableSet<Product> = TreeSet()
    ) : BaseEntity(), UserDetails {
    
    override fun getAuthorities(): MutableCollection<out GrantedAuthority>? {
       return null
    }

    override fun getPassword(): String {
        return userPassword
    }

    override fun getUsername(): String {
        return nickName
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}