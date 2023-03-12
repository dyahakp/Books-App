package com.dyah.dailyprojectresume

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dyah.dailyprojectresume.login.LoginActivity
import com.dyah.dailyprojectresume.register.RegisterFragment

class AuthFragmentAdapter (
    fragment: FragmentActivity,
    private val bundle: List<Bundle?>
) : FragmentStateAdapter(
    fragment,
) {

    private val fragment = listOf(
        ::LoginActivity,
        ::RegisterFragment,

    )
    override fun getItemCount()= fragment.size

    override fun createFragment(position: Int): Fragment {
        val fragmentName = fragment.getOrNull(position)
        val fragmentInstance = fragmentName?.invoke() as? Fragment ?: Fragment()

        val bundle = bundle.getOrNull(position)
        fragmentInstance.arguments = bundle

        return  fragmentInstance
    }

}
