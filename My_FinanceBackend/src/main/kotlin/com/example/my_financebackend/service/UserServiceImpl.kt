package com.example.my_financebackend.service

import com.example.my_financebackend.model.User
import com.example.my_financebackend.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

interface UserService {
    fun registerUser(username: String, password: String): User
    fun updateUser(user: User): User
    fun findByUsername(username: String): User?
    fun authenticate(username: String, password: String): Boolean
}

@Service
class UserServiceImpl(
    @Autowired private val userRepository: UserRepository,
) : UserService {

    private val logger = LoggerFactory.getLogger(UserServiceImpl::class.java)

    override fun registerUser(username: String, password: String): User {
        if (userRepository.findByUsername(username) != null){
            logger.error("Username $username already exists")
            throw DuplicateUsernameException("Username already exists")
        }
        val user = User().apply {
            this.username = username
            this.password = password
        }
        return userRepository.save(user)
    }

    override fun updateUser(user: User): User = userRepository.save(user)

    override fun findByUsername(username: String): User? = userRepository.findByUsername(username)

    override fun authenticate(username: String, password: String): Boolean {
        val user = findByUsername(username)
        return user?.password == password
    }

}
class DuplicateUsernameException(message: String) : RuntimeException(message)

