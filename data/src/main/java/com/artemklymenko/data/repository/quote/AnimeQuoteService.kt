package com.artemklymenko.data.repository.quote

import com.artemklymenko.domain.models.Quote
import retrofit2.http.GET

interface AnimeQuoteService {

    @GET("quotes/random")
    suspend fun randomAnimeQuote(): Quote
}