package com.moneymanager.apiserver.service.user

import com.moneymanager.apiserver.model.user.User
import com.moneymanager.apiserver.model.user.UserCreate

interface UserService {
    fun getByUsername(username: String): User
    fun create(userCreate: UserCreate): User
}