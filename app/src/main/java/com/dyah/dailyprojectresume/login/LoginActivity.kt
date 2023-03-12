package com.dyah.dailyprojectresume.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dyah.dailyprojectresume.home.HomeActivity
import com.dyah.dailyprojectresume.profile.ProfileActivity
import com.dyah.dailyprojectresume.register.RegisterActivity
import com.dyah.dailyprojectresume.databinding.ActivityLoginBinding
import com.dyah.dailyprojectresume.helper.Constant
import com.dyah.dailyprojectresume.helper.PreferenceHelper

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    lateinit var pref : PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pref = PreferenceHelper(this)
        supportActionBar?.hide()
        binding.btnLogin.setOnClickListener {
            val Pemail = pref.getString(Constant.PREF_EMAIL)
            val Ppassword = pref.getString(Constant.PREF_PASSWORD)
            var email = binding.etEmail.text.toString()
            var password = binding.etPassword.text.toString()

            if (email.contains(Pemail.toString()) || password.contains(Ppassword.toString()))
            {
                pref.put(Constant.PREF_IS_LOGIN, true)
                Toast.makeText(applicationContext, "Login Account Sucessfull", Toast.LENGTH_LONG).show()
                intentTo(ProfileActivity::class.java)
            }
        }
        binding.btnLogin.setOnClickListener {
            intentTo(HomeActivity::class.java)
        }

        binding.tvRegister.setOnClickListener {
            intentTo(RegisterActivity::class.java)
        }
    }

    override fun onStart() {
        super.onStart()
        if (pref.getBoolean(Constant.PREF_IS_LOGIN)){
            intentTo(HomeActivity::class.java)
        }
    }

    private fun intentTo(classs: Class<*>){
        val intent = Intent(this, classs)
        startActivity(intent)
    }
}