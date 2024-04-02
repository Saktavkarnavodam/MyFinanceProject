package com.example.my_financebackend.exception

import com.example.my_financebackend.service.DuplicateUsernameException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateUsernameException::class)
    fun handleDuplicateUsernameException(ex: DuplicateUsernameException): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.message)
    }
}
