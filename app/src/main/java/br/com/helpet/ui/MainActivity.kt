package br.com.helpet.ui

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import br.com.helpet.BuildConfig
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

        val splashScreenView = findViewById<FrameLayout>(R.id.splash_container)
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        splashScreenView.startAnimation(fadeIn)
        splashScreenScope.launch {
            delay(5000)
            setContentView(binding.root)

        }
    }
    override fun onDestroy() {
        super.onDestroy()
        splashScreenScope.cancel()
    }
}