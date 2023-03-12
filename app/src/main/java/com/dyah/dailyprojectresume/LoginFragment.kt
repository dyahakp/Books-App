package com.dyah.dailyprojectresume

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.dyah.dailyprojectresume.databinding.ActivityLoginBinding
import com.dyah.dailyprojectresume.databinding.ActivityViewPagerAuthBinding
import com.dyah.dailyprojectresume.databinding.FragmentLoginBinding

class LoginFragment  : Fragment() {

    val email = "dyah.akp@gmail.com"
    val name = "Dyah Anggraini Kartika Putri"
    val password = "Dyah29"


    private lateinit var binding: FragmentLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //biar inputnya bukan karakter tp string
        binding.btnLogin.setOnClickListener {
            val inputEmail = binding.etUser.text.toString()
            val inputPassword = binding.etPassword.text.toString()
            if (email == inputEmail && password == inputPassword) {
               // navigateScreenWithInput(ProfileActivity::class.java, inputEmail, inputPassword)
                Toast.makeText(applicationContext, "Login Successfull!", Toast.LENGTH_LONG).show()
                val intent = Intent (applicationContext, MainActivity::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(applicationContext, "Login Failed!", Toast.LENGTH_LONG).show()
                val intent = Intent (applicationContext, LoginFragment::class.java)
                startActivity(intent)


            }

          // showLoading()
        }
       // binding.pbLoading.setOnClickListener {
       //     hidingLoading()
        //}

    }

//    private fun showLoading() {
//        binding.pbLoading.visibility = View.VISIBLE
//        binding.btnSubmit.visibility = View.GONE
//
//    }
//
//    private fun hidingLoading() {
//        binding.pbLoading.visibility = View.GONE
//        binding.btnSubmit.visibility = View.VISIBLE
//
//    }

    private fun navigateScreen(screen: Class<*>,email : String, password : String) {
        val intent = Intent(applicationContext, screen)
        //companion object : konstant atau static
        intent.putExtra(KEY_EMAIL, email)
        intent.putExtra(KEY_PASSWORD, password)
        startActivity(intent)

    }

    private fun navigateScreenWithInput(screen: Class<*>, inputEmail: String, inputPassword: String) {
        val intent = Intent(applicationContext, screen)
        //companion object : konstant atau static
        intent.putExtra(KEY_EMAIL, inputEmail)
        intent.putExtra(KEY_PASSWORD, inputPassword)
        startActivity(intent)
    }

    companion object {
        const val KEY_PASSWORD = "password"
        const val KEY_EMAIL = "email"

    }


}