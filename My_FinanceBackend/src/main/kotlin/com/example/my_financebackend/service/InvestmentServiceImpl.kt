package com.example.my_financebackend.service

import com.example.my_financebackend.model.Investment
import com.example.my_financebackend.repository.InvestmentRepository
import org.springframework.stereotype.Service

interface InvestmentService {
    fun addInvestment(investment: Investment): Investment
    fun getInvestmentsByPortfolioId(portfolioId: Long): List<Investment>
}

@Service
class InvestmentServiceImpl(private val investmentRepository: InvestmentRepository) :
    InvestmentService {
    override fun addInvestment(investment: Investment): Investment = investmentRepository.save(investment)

    override fun getInvestmentsByPortfolioId(portfolioId: Long): List<Investment> =
        investmentRepository.findByPortfolioId(portfolioId)
}
