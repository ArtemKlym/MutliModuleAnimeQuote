package com.artemklymenko.mutlimoduleanimequote

import android.app.Application
import com.artemklymenko.mutlimoduleanimequote.di.AppContainer
import com.artemklymenko.presentation.MainViewModel
import com.artemklymenko.presentation.ProvideViewModel

class AnimeQuoteApp: Application(), ProvideViewModel {

    private lateinit var container: AppContainer

    private lateinit var viewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()
        container = AppContainer()
        viewModel = MainViewModel(container.getRandomQuoteUseCase)
    }

    override fun viewModel(): MainViewModel {
        return viewModel
    }

}