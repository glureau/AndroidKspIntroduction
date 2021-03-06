package com.glureau.androidkspintroduction

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.glureau.androidkspintroduction.databinding.FragmentSecondBinding
import com.glureau.magicfragment_androidlib.libs.MagicEmptyFragment
import com.glureau.magicfragment_lib.MagicFragment

@MagicFragment
class SecondFragment : MagicEmptyFragment<FragmentSecondBinding> {
    override fun Fragment.onViewCreated(binding: FragmentSecondBinding) {
        binding.textviewSecond.text = getString(R.string.secondfragment_text)
        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }
}

