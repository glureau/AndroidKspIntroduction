package com.glureau.magicfragment_androidlib.libs

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding


interface MagicEmptyFragment<VB : ViewBinding> {
    fun Fragment.onViewCreated(binding: VB) {}
    fun Fragment.onStart(binding: VB) {}
    fun Fragment.onResume(binding: VB) {}
    // ...
}

