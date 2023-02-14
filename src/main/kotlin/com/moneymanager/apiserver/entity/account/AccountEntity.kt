package com.moneymanager.apiserver.entity.account

import com.moneymanager.apiserver.entity.user.UserEntity
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.util.*

@Entity
@Table(name = "accounts")
data class AccountEntity(
    @Column(nullable = false)
    var name: String,
    @Column(nullable = false)
    var accountType: AccountType,
    @Column(nullable = false)
    var currency: Currency,
    @ManyToOne(fetch = FetchType.EAGER)
    val user: UserEntity
) {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null
    @Column(nullable = false)
    var balance: Double = 0.0
    @CreatedDate
    var createdDate: Date? = null
    @LastModifiedDate
    var lastModifiedDate: Date? = null
}
