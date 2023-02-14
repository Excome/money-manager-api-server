package com.moneymanager.apiserver.exception

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice
class RestExceptionHandler: ResponseEntityExceptionHandler() {
    private val log: Logger = LogManager.getLogger(RestExceptionHandler::class)

    @ExceptionHandler(UserException::class)
    fun handleUserException(ex: UserException): ResponseEntity<Any> {
        log.error(ex.message)

        return ResponseEntity(ex.message, HttpStatus.BAD_REQUEST)
    }
}