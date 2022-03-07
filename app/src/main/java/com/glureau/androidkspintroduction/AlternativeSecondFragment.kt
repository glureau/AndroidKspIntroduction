package com.glureau.androidkspintroduction

import androidx.viewbinding.ViewBinding
import com.glureau.androidkspintroduction.databinding.FragmentSecondBinding

@MagicFragment
class AlternativeSecondFragment : DefaultFragment<FragmentSecondBinding> {
    override fun FragmentSecondBinding.onViewCreated() {

    }
}

annotation class MagicFragment()

interface DefaultFragment<VB : ViewBinding> {
    fun VB.onViewCreated() {}
    fun VB.onStart() {}
    fun VB.onResume() {}
    // ...
}
