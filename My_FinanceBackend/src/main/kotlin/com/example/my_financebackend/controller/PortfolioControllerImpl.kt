package com.example.my_financebackend.controller

import com.example.my_financebackend.model.Portfolio
import com.example.my_financebackend.service.PortfolioServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

interface PortfolioController {
    @PostMapping("/create")
    fun createPortfolio(@RequestParam portfolio: Portfolio): ResponseEntity<Portfolio>

    @GetMapping("/{portfolioId}")
    fun getPortfolioById(@RequestParam portfolioId: Long): ResponseEntity<Portfolio>

    @PutMapping("/update/{portfolioId}")
    fun updatePortfolio(@RequestParam portfolioId: Long, @RequestBody portfolio: Portfolio): ResponseEntity<Portfolio>

    @DeleteMapping("/delete/{portfolioId}")
    fun deletePortfolio(@RequestParam portfolioId: Long): ResponseEntity<Void>
}

@RestController
@RequestMapping("/api/portfolios")
class PortfolioControllerImpl(@Autowired private val portfolioService: PortfolioServiceImpl) : PortfolioController {

    // Эндпоинт для создания портфеля
    @PostMapping("/create")
    override fun createPortfolio(@RequestParam portfolio: Portfolio): ResponseEntity<Portfolio> {
        val createdPortfolio = portfolioService.createPortfolio(portfolio)
        return ResponseEntity.ok(createdPortfolio)
    }

    // Эндпоинт для получения портфеля по ID
    @GetMapping("/{portfolioId}")
    override fun getPortfolioById(@RequestParam portfolioId: Long): ResponseEntity<Portfolio> {
        val portfolio = portfolioService.findPortfolioById(portfolioId)
        return if (portfolio != null) ResponseEntity.ok(portfolio) else ResponseEntity.notFound().build()
    }

    // Эндпоинт для обновления портфеля
    @PutMapping("/update/{portfolioId}")
    override fun updatePortfolio(@RequestParam portfolioId: Long, @RequestBody portfolio: Portfolio): ResponseEntity<Portfolio> {
        val updatedPortfolio = portfolioService.updatePortfolio(portfolioId, portfolio)
        return ResponseEntity.ok(updatedPortfolio)
    }

    // Эндпоинт для удаления портфеля
    @DeleteMapping("/delete/{portfolioId}")
    override fun deletePortfolio(@RequestParam portfolioId: Long): ResponseEntity<Void> {
        portfolioService.deletePortfolioById(portfolioId)
        return ResponseEntity.noContent().build()
    }
}
