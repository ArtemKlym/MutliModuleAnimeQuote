package com.artemklymenko.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artemklymenko.domain.models.Quote
import com.artemklymenko.domain.usecase.quote.GetRandomQuoteUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val getRandomQuoteUseCase: GetRandomQuoteUseCase
): ViewModel() {

    private val _quoteState = MutableStateFlow<Quote?>(null)
    val quoteState: StateFlow<Quote?> get() = _quoteState

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    fun loadRandomQuote() {
        viewModelScope.launch {
            _isLoading.value = true
            val quote = getRandomQuoteUseCase.invoke().second
            if (quote != null) {
                _quoteState.emit(quote)
            }
            _isLoading.value = false
        }
    }
}