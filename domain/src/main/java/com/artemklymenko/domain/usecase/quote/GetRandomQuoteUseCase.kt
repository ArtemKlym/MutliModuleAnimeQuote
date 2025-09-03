package com.artemklymenko.domain.usecase.quote

import com.artemklymenko.domain.models.Quote
import com.artemklymenko.domain.repository.QuoteRepository
import com.artemklymenko.domain.repository.QuoteResult
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val quoteRepository: QuoteRepository
) {

    suspend operator fun invoke(): QuoteResult {
        return quoteRepository.loadRandomQuote()
    }
}