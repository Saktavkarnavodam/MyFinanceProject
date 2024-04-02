package com.example.my_financebackend.service

import com.example.my_financebackend.model.Portfolio
import com.example.my_financebackend.repository.PortfolioRepository
import org.springframework.stereotype.Service

interface PortfolioService {
    fun createPortfolio(portfolio: Portfolio): Portfolio
    fun findPortfolioById(id: Long): Portfolio?
    fun updatePortfolio(portfolioId: Long, portfolio: Portfolio): Portfolio
    fun deletePortfolioById(id: Long)
}

@Service
class PortfolioServiceImpl(private val portfolioRepository: PortfolioRepository) :
    PortfolioService {
    override fun createPortfolio(portfolio: Portfolio): Portfolio = portfolioRepository.save(portfolio)

    override fun findPortfolioById(id: Long): Portfolio? = portfolioRepository.findById(id).orElse(null)

    override fun updatePortfolio(portfolioId: Long, portfolio: Portfolio): Portfolio = portfolioRepository.save(portfolio)

    override fun deletePortfolioById(id: Long) = portfolioRepository.deleteById(id)
}
