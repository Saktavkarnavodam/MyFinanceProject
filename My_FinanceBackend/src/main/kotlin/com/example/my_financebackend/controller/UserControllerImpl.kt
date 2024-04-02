package com.example.my_financebackend.controller

import com.example.my_financebackend.model.User
import com.example.my_financebackend.service.UserServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

interface UserController {
    @PostMapping("/register")
    fun registerUser(user: User): ResponseEntity<Any>

    @PostMapping("/login")
    fun loginUser(user: User): ResponseEntity<Any>
}

@RestController
@RequestMapping("/api/user")
class UserControllerImpl(@Autowired private val userService: UserServiceImpl) :
    UserController {

    @PostMapping("/register")
    override fun registerUser(@RequestBody user: User): ResponseEntity<Any> {
        userService.registerUser(user.username!!, user.password!!)
        println("OK")
        return ResponseEntity.ok().build<Any>()
    }

    @PostMapping("/login")
    override fun loginUser(@RequestBody user: User): ResponseEntity<Any> {
        val isAuthenticated = userService.authenticate(user.username!!, user.password!!)
        return if (isAuthenticated) ResponseEntity.ok().build<Any>() else ResponseEntity.status(401).build()
    }
}
