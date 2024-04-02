package com.example.my_financebackend.model

import jakarta.persistence.*

@Entity
@Table(name = "investments")
class Investment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
    var type: String? = null // Тип ценной бумаги
    var quantity: Int = 0 // Количество
    var purchasePrice: Double = 0.0 // Цена покупки

    @ManyToOne
    @JoinColumn(name = "portfolio_id", nullable = false)
    var portfolio: Portfolio? = null
}


