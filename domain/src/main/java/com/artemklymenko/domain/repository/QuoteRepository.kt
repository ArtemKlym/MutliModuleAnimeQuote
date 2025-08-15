package com.artemklymenko.domain.repository

import com.artemklymenko.domain.models.Quote

interface QuoteRepository {

    suspend fun loadRandomQuote(): Pair<Boolean, Quote>
}