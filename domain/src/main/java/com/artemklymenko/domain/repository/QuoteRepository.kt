package com.artemklymenko.domain.repository

interface QuoteRepository {

    suspend fun loadRandomQuote(): QuoteResult
}