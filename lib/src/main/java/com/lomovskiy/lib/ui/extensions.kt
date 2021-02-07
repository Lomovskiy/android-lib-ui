@file:Suppress("NOTHING_TO_INLINE")
package com.lomovskiy.lib.ui

import android.content.Context
import android.text.InputType
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.annotation.StringRes
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import com.google.android.material.textfield.TextInputLayout

// region dialog
inline fun FragmentActivity.showDialog(tag: String, dialog: DialogFragment) {
    if (isFinishing) {
        return
    }
    if (supportFragmentManager.findFragmentByTag(tag) != null) {
        return
    }
    dialog.show(supportFragmentManager, tag)
}

inline fun FragmentActivity.dismissDialog(tag: String) {
    if (isFinishing) {
        return
    }
    (supportFragmentManager.findFragmentByTag(tag) as? DialogFragment)?.dismissAllowingStateLoss()
}

inline fun Fragment.showDialog(tag: String, dialog: DialogFragment) {
    if (!isAdded) {
        return
    }
    if (childFragmentManager.findFragmentByTag(tag) != null) {
        return
    }
    dialog.show(childFragmentManager, tag)
}

inline fun Fragment.dismissDialog(tag: String) {
    if (!isAdded) {
        return
    }
    (childFragmentManager.findFragmentByTag(tag) as? DialogFragment)?.dismissAllowingStateLoss()
}
// endregion

// region toast
inline fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

inline fun Fragment.showToast(message: String) {
    requireContext().showToast(message)
}
// endregion

//region field
inline fun TextInputLayout.editText(): EditText {
    return editText!!
}

inline fun EditText.setReadOnly(isReadOnly: Boolean, inputType: Int = InputType.TYPE_NULL) {
    isFocusable = !isReadOnly
    isFocusableInTouchMode = !isReadOnly
    if (!isReadOnly) {
        this.inputType = inputType
    }
}

inline fun TextInputLayout.setReadOnly(isReadOnly: Boolean, inputType: Int = InputType.TYPE_NULL) {
    editText().setReadOnly(isReadOnly, inputType)
}

inline fun TextInputLayout.text(): String {
    return editText().text.toString()
}

inline fun TextInputLayout.setText(text: String) {
    editText().setText(text)
}

inline fun TextInputLayout.setText(@StringRes id: Int) {
    editText().setText(id)
}
//endregion

inline fun View.setVisible(isVisible: Boolean, isUseGone: Boolean = true) {
    visibility = when {
        isVisible -> View.VISIBLE
        isUseGone -> View.GONE
        else -> View.INVISIBLE
    }
}

inline fun Fragment.registerOnBackPressedCallback(lifecycleOwner: LifecycleOwner, callback: OnBackPressedCallback) {
    requireActivity().onBackPressedDispatcher.addCallback(lifecycleOwner, callback)
}
