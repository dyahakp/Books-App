package com.dyah.dailyprojectresume.register

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dyah.dailyprojectresume.login.LoginActivity
import com.dyah.dailyprojectresume.databinding.ActivityRegisteredBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RegisteredActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisteredBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisteredBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        CoroutineScope(Dispatchers.Main).launch {
            delay(3000L)
            val intent = Intent (applicationContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }}
