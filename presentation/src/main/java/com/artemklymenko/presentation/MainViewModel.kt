package com.artemklymenko.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artemklymenko.domain.models.Quote
import com.artemklymenko.domain.repository.QuoteRepository
import com.artemklymenko.domain.repository.QuoteResult
import com.artemklymenko.domain.usecase.quote.GetRandomQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getRandomQuoteUseCase: GetRandomQuoteUseCase,
    private val mapper: QuoteResult.Mapper<QuoteUiState>
): ViewModel() {

    private val _quoteState = MutableStateFlow<QuoteUiState?>(null)
    val quoteState: StateFlow<QuoteUiState?> get() = _quoteState

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    fun loadRandomQuote() {
        viewModelScope.launch {
            _isLoading.value = true
            val quoteResult = getRandomQuoteUseCase.invoke()
            val uiState = quoteResult.map(mapper)
            _quoteState.emit(uiState)

            _isLoading.value = false
        }
    }
}