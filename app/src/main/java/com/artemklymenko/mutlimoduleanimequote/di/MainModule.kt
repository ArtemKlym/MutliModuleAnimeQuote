package com.artemklymenko.mutlimoduleanimequote.di

import com.artemklymenko.data.repository.quote.QuoteRepositoryImpl
import com.artemklymenko.domain.repository.QuoteRepository
import com.artemklymenko.domain.repository.QuoteResult
import com.artemklymenko.presentation.QuoteUiMapper
import com.artemklymenko.presentation.QuoteUiState
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MainModule {

    @Binds
    abstract fun provideQuoteRepository(impl: QuoteRepositoryImpl): QuoteRepository

    @Binds
    abstract fun provideMapper(mapper: QuoteUiMapper): QuoteResult.Mapper<QuoteUiState>
}