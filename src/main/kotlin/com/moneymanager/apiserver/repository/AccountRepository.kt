package com.moneymanager.apiserver.repository

import com.moneymanager.apiserver.entity.account.AccountEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface AccountRepository: JpaRepository<AccountEntity, UUID> {

    fun findAllByUserUsername(username: String): MutableList<AccountEntity>
}