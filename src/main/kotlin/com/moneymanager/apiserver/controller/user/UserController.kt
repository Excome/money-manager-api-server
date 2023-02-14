package com.moneymanager.apiserver.controller.user

import com.moneymanager.apiserver.model.user.User
import com.moneymanager.apiserver.model.user.UserCreate
import org.springframework.http.ResponseEntity

interface UserController {
    fun getByUsername(username: String): ResponseEntity<User>
    fun create(userCreate: UserCreate): ResponseEntity<User>
}