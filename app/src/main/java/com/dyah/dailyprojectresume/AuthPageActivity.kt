package com.dyah.dailyprojectresume

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dyah.dailyprojectresume.databinding.ActivityViewPagerAuthBinding
import com.google.android.material.tabs.TabLayoutMediator

class AuthPageActivity: AppCompatActivity() {
    private lateinit var binding: ActivityViewPagerAuthBinding

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        binding = ActivityViewPagerAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        setUpViewPager(listOf())
        setUpTabLayout()
    }

    private fun setUpViewPager(bundle: List<Bundle?>) {
        val viewPager = binding.vpContainer
        viewPager.adapter = AuthFragmentAdapter(this, bundle)
    }

    private fun setUpTabLayout() {
        val tabLayout = binding.tabLayout
        val viewPager = binding.vpContainer
        //overriding
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Login"
                1 -> tab.text = "Register"
            }
        }.attach()

    }
}