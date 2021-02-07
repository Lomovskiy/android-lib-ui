package com.lomovskiy.lib.ui.dialog

import android.app.Dialog
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.annotation.StyleRes
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.lomovskiy.lib.ui.EXTRA_RENDER_MODEL
import com.lomovskiy.lib.ui.R
import com.lomovskiy.lib.ui.RES_UNDEFINED
import kotlinx.parcelize.Parcelize

class DialogProgress : DialogFragment() {

    companion object {

        const val TAG = "DialogProgress"

        @JvmStatic
        @JvmOverloads
        fun newInstance(config: Config? = null) : DialogProgress {
            return DialogProgress().apply {
                arguments = Bundle().apply {
                    if (config != null) {
                        putParcelable(EXTRA_RENDER_MODEL, config)
                    }
                }
            }
        }

    }

    private val config: Config?
        get() = requireArguments().getParcelable(EXTRA_RENDER_MODEL)

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder
        if (config == null || config!!.style == RES_UNDEFINED) {
             builder = AlertDialog.Builder(requireContext())
        } else {
            builder = AlertDialog.Builder(requireContext(), config!!.style)
        }
        val view: View = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_progress, null)
        if (config != null && config!!.message != RES_UNDEFINED) {
            view.findViewById<TextView>(R.id.label_message).setText(config!!.message)
        } else {
            view.findViewById<TextView>(R.id.label_message).setText(R.string.dialog_progress_message)
        }
        builder.setView(view)
        return builder.create().apply {
            setCanceledOnTouchOutside(false)
        }
    }

    @Parcelize
    class Config @JvmOverloads constructor(
        @StringRes val message: Int = R.string.dialog_progress_message,
        @StyleRes val style: Int = RES_UNDEFINED
    ) : Parcelable

}
