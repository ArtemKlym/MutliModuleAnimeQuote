package com.artemklymenko.mutlimoduleanimequote.di

import com.artemklymenko.data.repository.quote.QuoteRepositoryImpl
import com.artemklymenko.domain.repository.QuoteRepository
import com.artemklymenko.domain.usecase.quote.GetRandomQuoteUseCase

class AppContainer {

    private val repository: QuoteRepository by lazy {
        QuoteRepositoryImpl()
    }

    val getRandomQuoteUseCase: GetRandomQuoteUseCase by lazy {
        GetRandomQuoteUseCase(repository)
    }
}
