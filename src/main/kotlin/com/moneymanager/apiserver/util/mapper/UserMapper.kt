package com.moneymanager.apiserver.util.mapper

import com.moneymanager.apiserver.entity.user.UserEntity
import com.moneymanager.apiserver.model.user.User
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
interface UserMapper {
        fun mapToUser(entity: UserEntity): User
}