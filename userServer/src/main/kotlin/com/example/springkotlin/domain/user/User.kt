package com.example.springkotlin.domain.user

import com.example.springkotlin.common.UserRole
import com.example.springkotlin.domain.BaseEntity
import com.example.springkotlin.domain.product.Product
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import javax.persistence.*

@Entity
class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: Long? = null,
    var nickName: String,
    var m_password: String,
    var credit: Int,
    @OneToMany(mappedBy = "user")
    var productSet: MutableSet<Product> = TreeSet()
    ) : BaseEntity(), UserDetails {

        fun addProduct(product: Product) {
            productSet.add(product)
        }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority>? {
       return null
    }

    override fun getPassword(): String {
        return m_password
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