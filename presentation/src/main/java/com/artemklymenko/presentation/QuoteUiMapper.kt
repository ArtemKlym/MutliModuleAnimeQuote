package com.artemklymenko.presentation

import com.artemklymenko.domain.models.Quote
import com.artemklymenko.domain.repository.QuoteResult
import javax.inject.Inject

class QuoteUiMapper @Inject constructor(): QuoteResult.Mapper<QuoteUiState> {
    override fun mapSuccess(quote: Quote): QuoteUiState {
        return QuoteUiState.Success(quote)
    }

    override fun mapError(message: String): QuoteUiState {
        return QuoteUiState.Error(message)
    }
}