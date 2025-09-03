package com.artemklymenko.domain.repository

import com.artemklymenko.domain.models.Quote

interface QuoteResult {

    fun <T: Any> map(mapper: Mapper<T>): T

    interface  Mapper<T: Any> {

        fun mapSuccess(quote: Quote): T

        fun mapError(message: String): T
    }

    data class Success(private val quote: Quote): QuoteResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapSuccess(quote)
        }
    }

    data class Error(private val message: String): QuoteResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapError(message)
        }
    }
}