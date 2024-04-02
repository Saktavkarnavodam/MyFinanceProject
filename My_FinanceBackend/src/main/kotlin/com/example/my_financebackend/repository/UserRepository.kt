package com.example.my_financebackend.repository

import com.example.my_financebackend.model.User
import org.springframework.data.jpa.repository.JpaRepository


interface UserRepository : JpaRepository<User?, Long?>{
    fun findByUsername(username: String): User?
}
