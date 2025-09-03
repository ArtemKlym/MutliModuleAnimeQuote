package com.artemklymenko.data.repository.quote

import com.artemklymenko.domain.repository.QuoteRepository
import com.artemklymenko.domain.repository.QuoteResult
import javax.inject.Inject

class QuoteRepositoryImpl @Inject constructor(
    private val service: AnimeQuoteService
) : QuoteRepository {

    override suspend fun loadRandomQuote(): QuoteResult {
        return try {
            val quote = service.randomAnimeQuote()
            QuoteResult.Success(quote)
        } catch (e: Exception) {
            QuoteResult.Error(e.message ?: "error")
        }
    }
}