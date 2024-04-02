package com.example.my_financebackend.repository

import com.example.my_financebackend.model.Investment
import org.springframework.data.jpa.repository.JpaRepository


interface InvestmentRepository : JpaRepository<Investment?, Long?> {
    fun findByPortfolioId(portfolioId: Long): List<Investment>
}

