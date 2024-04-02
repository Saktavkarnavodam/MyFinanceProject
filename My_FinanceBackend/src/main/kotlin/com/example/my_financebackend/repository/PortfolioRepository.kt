package com.example.my_financebackend.repository

import com.example.my_financebackend.model.Portfolio
import org.springframework.data.jpa.repository.JpaRepository

interface PortfolioRepository : JpaRepository<Portfolio, Long>
