package com.dyah.dailyprojectresume.profile

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dyah.dailyprojectresume.databinding.ActivityProfileBinding
import com.dyah.dailyprojectresume.helper.Constant
import com.dyah.dailyprojectresume.helper.PreferenceHelper
import com.dyah.dailyprojectresume.login.LoginActivity

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    lateinit var pref: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        pref = PreferenceHelper(this)

        binding.tvEmail.text = pref.getString(Constant.PREF_EMAIL)
        binding.tvPassword.text = pref.getString(Constant.PREF_PASSWORD)
        binding.tvAddress.text = pref.getString(Constant.PREF_ADDRESS)
        binding.tvNoTelp.text = pref.getString(Constant.PREF_NUMBER_PHONE)

        Log.d(TAG, pref.getString(Constant.PREF_EMAIL).toString())

        binding.includeAppbar.ivArrow.setOnClickListener {
            onBackPressed()
        }

        binding.btnLogout.setOnClickListener {
            pref.clear()
            Toast.makeText(this, "Logout Successfull", Toast.LENGTH_LONG).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }


    }


}