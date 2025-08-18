package com.artemklymenko.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.artemklymenko.presentation.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val viewModel = (application as ProvideViewModel).viewModel()

        binding.btnGetAQuote.setOnClickListener {
            viewModel.loadRandomQuote()
        }

        lifecycleScope.launch {
            viewModel.quoteState.filterNotNull().collect { quote ->
                binding.tvQuote.text = quote.data.content
                binding.pbQuote.visibility = View.GONE
            }

            viewModel.isLoading.collect { loading ->
                binding.pbQuote.visibility = if (loading) View.VISIBLE else View.GONE
            }
        }
    }
}