package com.moneymanager.apiserver.entity.user

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.util.*

@Entity
@Table(name = "users")
data class UserEntity(
    @Column(nullable = false, unique = true)
    var username: String,
    @Column(nullable = false)
    var password: String,
    @Column(nullable = false)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = [JoinColumn(name = "user_id")])
    @Enumerated(EnumType.STRING)
    var roles: MutableSet<Role>
) {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null
    @Column(nullable = false)
    var enabled: Boolean = false
    @CreatedDate
    var createdDate: Date? = null
    @LastModifiedDate
    var lastModifiedDate: Date? = null
}