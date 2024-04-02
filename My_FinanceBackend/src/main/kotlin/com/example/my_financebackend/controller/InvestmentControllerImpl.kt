package com.example.my_financebackend.controller

import com.example.my_financebackend.model.Investment
import com.example.my_financebackend.service.InvestmentServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

interface InvestmentController {
    @PostMapping("/addInvestment")
    fun addInvestment(investment: Investment): ResponseEntity<Investment>

    @GetMapping("/{portfolioId}")
    fun getInvestmentsByPortfolioId(portfolioId: Long): ResponseEntity<List<Investment>>
}

@RestController
@RequestMapping("/api/investments")
class InvestmentControllerImpl(@Autowired private val investmentService: InvestmentServiceImpl) :
    InvestmentController {

    @PostMapping("/addInvestment")
    override fun addInvestment(@RequestBody investment: Investment): ResponseEntity<Investment> =
        ResponseEntity.ok(investmentService.addInvestment(investment))

    @GetMapping("/{portfolioId}")
    override fun getInvestmentsByPortfolioId(@PathVariable portfolioId: Long): ResponseEntity<List<Investment>> =
        ResponseEntity.ok(investmentService.getInvestmentsByPortfolioId(portfolioId))
}
