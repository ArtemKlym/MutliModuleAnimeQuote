package com.artemklymenko.data.repository.quote

import com.artemklymenko.domain.models.Quote
import com.artemklymenko.domain.repository.QuoteRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuoteRepositoryImpl(
    private val service: AnimeQuoteService
) : QuoteRepository {

    constructor() : this(
        Retrofit.Builder()
            .baseUrl("https://api.animechan.io/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AnimeQuoteService::class.java)
    )

    override suspend fun loadRandomQuote(): Pair<Boolean, Quote?> {
        return try {
            val quote = service.randomAnimeQuote()
            Pair(true, quote)
        } catch (e: Exception) {
            Pair(false, null)
        }
    }
}