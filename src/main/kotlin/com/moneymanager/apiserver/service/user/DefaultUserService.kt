package com.moneymanager.apiserver.service.user

import com.moneymanager.apiserver.controller.user.UserRestController
import com.moneymanager.apiserver.entity.user.Role
import com.moneymanager.apiserver.entity.user.UserEntity
import com.moneymanager.apiserver.exception.UserException
import com.moneymanager.apiserver.model.user.User
import com.moneymanager.apiserver.model.user.UserCreate
import com.moneymanager.apiserver.repository.UserRepository
import com.moneymanager.apiserver.util.mapper.UserMapper
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.stereotype.Service

@Service
class DefaultUserService(
    var userRepository: UserRepository,
    var userMapper: UserMapper
): UserService {
    private val log: Logger = LogManager.getLogger(DefaultUserService::class)

    override fun getByUsername(username: String): User {
        log.debug("Gonna get user by '$username' username")
        if (username.isBlank()){
            throw UserException("Username cannot be blank")
        }

        val entity = userRepository.findUserByUsername(username)
            ?: throw UserException("User with '$username' not found!")
        log.debug("Received entity from DB: $entity.")

        return userMapper.mapToUser(entity)
    }

    override fun create(userCreate: UserCreate): User {
        log.debug("Try to create new user: $userCreate")
        if (userCreate.username.isBlank() || userCreate.password.isBlank() || userCreate.passwordConfirm.isBlank()) {
            throw UserException("Cannot create user. All fields must be filled: $userCreate")
        }

        val userFromDb = userRepository.findUserByUsername(userCreate.username);
        if (userFromDb != null) {
            throw UserException("User with '${userCreate.username}' already exist!")
        }

        if (userCreate.password != userCreate.passwordConfirm) {
            throw UserException("Cannot create user $userCreate. Password and Password Confirm aren't equal.")
        }

        val userEntity = userRepository.save(
            UserEntity(
                userCreate.username,
                userCreate.password,
                mutableSetOf(Role.ROLE_USER)
            )
        )
        log.debug("New user created: $userEntity")

        return userMapper.mapToUser(userEntity)
    }


}