package com.example.my_financebackend.model


import jakarta.persistence.*


@Entity
@Table(name = "users")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
    var username: String? = null
    var password: String? = null

    @OneToMany(mappedBy = "user", cascade = arrayOf(CascadeType.ALL))
    private val portfolios: List<Portfolio>? = null // Геттеры и сеттеры
}

