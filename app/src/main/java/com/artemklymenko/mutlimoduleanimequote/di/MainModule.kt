package com.artemklymenko.mutlimoduleanimequote.di

import com.artemklymenko.data.repository.quote.QuoteRepositoryImpl
import com.artemklymenko.domain.repository.QuoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MainModule {

    @Binds
    abstract fun provideQuoteRepository(impl: QuoteRepositoryImpl): QuoteRepository
}