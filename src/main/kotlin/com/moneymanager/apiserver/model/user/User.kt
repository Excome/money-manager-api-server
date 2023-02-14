package com.moneymanager.apiserver.model.user

import com.moneymanager.apiserver.entity.user.Role
import java.util.Date
import java.util.UUID

class User(
    var id: UUID,
    var username: String,
    var roles: MutableSet<Role>,
    var enabled: Boolean,
    var createdDate: Date,
    var lastModifiedDate: Date
)