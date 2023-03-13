package com.dyah.dailyprojectresume.register

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dyah.dailyprojectresume.databinding.ActivityRegisterBinding
import com.dyah.dailyprojectresume.helper.Constant
import com.dyah.dailyprojectresume.helper.PreferenceHelper
import com.dyah.dailyprojectresume.login.LoginActivity

class RegisterActivity : AppCompatActivity() {
        private lateinit var binding: ActivityRegisterBinding
        lateinit var pref: PreferenceHelper

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityRegisterBinding.inflate(layoutInflater)
            setContentView(binding.root)
             pref = PreferenceHelper(this)
            supportActionBar?.hide()

            binding.apply {
                btnRegister.setOnClickListener {
                    val email = etEmail.text
                    val password = etPassword.text
                    val address = etAddress.text
                    val numberPhone = etNoHandphone.text

                    if (email.isNullOrEmpty() && password.isNullOrEmpty() && address.isNullOrEmpty() && numberPhone.isNullOrEmpty()){
                        Toast.makeText(applicationContext, "Field Cannot be empty", Toast.LENGTH_LONG).show()
                    } else {
                      pref.put(Constant.PREF_EMAIL, email.toString())
                        pref.put(Constant.PREF_PASSWORD, password.toString())
                       pref.put(Constant.PREF_ADDRESS, password.toString())
                       pref.put(Constant.PREF_NUMBER_PHONE, numberPhone.toString())
                        intentTo(RegisteredActivity::class.java)
                    }
                }
                binding.tvRegisterNow.setOnClickListener {
                    intentTo(LoginActivity::class.java)
                }

            }


        }


        private fun intentTo(classs: Class<*>){
            val intent = Intent(this, classs)
            startActivity(intent)
        }
    }