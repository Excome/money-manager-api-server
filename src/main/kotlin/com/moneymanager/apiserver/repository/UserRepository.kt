package com.moneymanager.apiserver.repository

import com.moneymanager.apiserver.entity.user.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository: JpaRepository<UserEntity, UUID> {
    fun findUserByUsername(username: String): UserEntity?
}