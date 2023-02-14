package com.moneymanager.apiserver.model.user

class UserCreate(
    var username: String,
    var password: String,
    var passwordConfirm: String
)