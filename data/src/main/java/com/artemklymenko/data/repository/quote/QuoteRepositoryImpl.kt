package com.artemklymenko.data.repository.quote

import com.artemklymenko.domain.models.Quote
import com.artemklymenko.domain.repository.QuoteRepository
import javax.inject.Inject

class QuoteRepositoryImpl @Inject constructor(
    private val service: AnimeQuoteService
) : QuoteRepository {

    override suspend fun loadRandomQuote(): Pair<Boolean, Quote?> {
        return try {
            val quote = service.randomAnimeQuote()
            Pair(true, quote)
        } catch (e: Exception) {
            Pair(false, null)
        }
    }
}