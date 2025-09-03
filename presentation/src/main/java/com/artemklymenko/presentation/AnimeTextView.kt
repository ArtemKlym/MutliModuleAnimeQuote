package com.artemklymenko.presentation

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import com.google.android.material.textview.MaterialTextView

class AnimeTextView : MaterialTextView, ShowQuote {

    constructor(context: Context): super(context)
    constructor(context: Context, attrs: AttributeSet): super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyle: Int): super(context, attrs, defStyle)


    override fun showQuote(quote: String) {
    }

    override fun showCharacter(character: String) {
    }

    override fun showAnime(anime: String) {
        text = anime
    }

    override fun showError(message: String) {

    }

    override fun showPrimaryColor() {
        setTextColor(ContextCompat.getColor(context, com.google.android.material.R.color.design_default_color_primary_dark))
    }

    override fun showErrorColor() {
        setTextColor(Color.RED)
    }

}