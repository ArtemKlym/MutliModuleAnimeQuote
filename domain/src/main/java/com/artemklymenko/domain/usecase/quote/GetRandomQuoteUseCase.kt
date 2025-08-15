package com.artemklymenko.domain.usecase.quote

import com.artemklymenko.domain.models.Quote
import com.artemklymenko.domain.repository.QuoteRepository

class GetRandomQuoteUseCase(
    private val quoteRepository: QuoteRepository
) {

    suspend operator fun invoke(): Pair<Boolean, Quote> {
        return quoteRepository.loadRandomQuote()
    }
}