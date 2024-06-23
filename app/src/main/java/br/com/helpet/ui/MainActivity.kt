package br.com.helpet.ui

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import br.com.helpet.R
import br.com.helpet.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val splashScreenScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_splash)

        // Aplicar a animação de fade-in na splash screen
        val splashScreenView = findViewById<FrameLayout>(R.id.splash_container)
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        splashScreenView.startAnimation(fadeIn)

        splashScreenScope.launch {
            // Simulando uma operação de carregamento de dados com delay
            delay(5000) // 5 segundos de atraso para simular o carregamento
            setContentView(binding.root)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        splashScreenScope.cancel() // Cancele a coroutine quando a atividade for destruída
    }
}