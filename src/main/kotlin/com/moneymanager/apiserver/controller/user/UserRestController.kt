package com.moneymanager.apiserver.controller.user

import com.moneymanager.apiserver.model.user.User
import com.moneymanager.apiserver.model.user.UserCreate
import com.moneymanager.apiserver.service.user.UserService
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserRestController(
    val userService: UserService
): UserController {
    private val log: Logger = LogManager.getLogger(UserRestController::class)

    @GetMapping("/{username}")
    override fun getByUsername(@PathVariable username: String): ResponseEntity<User> {
        val user = userService.getByUsername(username)
        log.debug("Returned user '$username': $user")
        return ResponseEntity.ok(user);
    }

    @PostMapping
    override fun create(@RequestBody userCreate: UserCreate): ResponseEntity<User> {
        val user = userService.create(userCreate)
        log.debug("Created user: $user")
        return ResponseEntity.ok(user)
    }
}