package com.artemklymenko.presentation

import com.artemklymenko.domain.models.Quote

interface QuoteUiState {

    fun showText(text: ShowQuote)

    data class Success(private val quote: Quote): QuoteUiState {
        override fun showText(text: ShowQuote) {
            text.showQuote(quote = quote.data.content)
            text.showCharacter(character = quote.data.character.name)
            text.showAnime(anime = quote.data.anime.name)
            text.showPrimaryColor()
        }
    }

    data class Error(private val message: String): QuoteUiState {
        override fun showText(text: ShowQuote) {
            text.showError(message)
            text.showErrorColor()
        }
    }
}

interface ShowQuote {

    fun showQuote(quote: String)

    fun showCharacter(character: String)

    fun showAnime(anime: String)

    fun showError(message: String)

    fun showPrimaryColor()

    fun showErrorColor()
}

