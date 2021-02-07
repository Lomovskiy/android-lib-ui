package com.lomovskiy.lib.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class XmlScreen(
    @LayoutRes private val layoutResId: Int
) : Fragment() {

    abstract fun findViews(parent: View)

    abstract fun setListeners()

    private val onBackPressedCallback: OnBackPressedCallback = object : OnBackPressedCallback(true) {

        override fun handleOnBackPressed() {
            onBackPressed()
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutResId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerOnBackPressedCallback(viewLifecycleOwner, onBackPressedCallback)
        findViews(parent = view)
        setListeners()
    }

    open fun onBackPressed() {}

}
