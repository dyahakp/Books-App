package com.dyah.dailyprojectresume.register

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dyah.dailyprojectresume.AuthPageActivity
import com.dyah.dailyprojectresume.databinding.ActivitySplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RegisterFragment {
    class SplashActivity : AppCompatActivity() {
        private lateinit var binding: ActivitySplashBinding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivitySplashBinding.inflate(layoutInflater)
            setContentView(binding.root)

            supportActionBar?.hide()
            CoroutineScope(Dispatchers.Main).launch {
                delay(6000L)
                val intent = Intent (applicationContext, AuthPageActivity::class.java)
                startActivity(intent)
                finish()
            }


        }
    }
}