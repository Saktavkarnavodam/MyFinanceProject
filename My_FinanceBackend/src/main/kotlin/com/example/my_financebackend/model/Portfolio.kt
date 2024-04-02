package com.example.my_financebackend.model


import jakarta.persistence.*
import java.security.Security


@Entity
@Table(name = "portfolios")
class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null
    private var name: String? = null
    private var description: String? = null

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private var user: User? = null

    @OneToMany(mappedBy = "portfolio", cascade = arrayOf(CascadeType.ALL))
    private var securities: List<Investment>? = null // Геттеры и сеттеры
}

