package com.lomovskiy.android.lib.ui.dialog

import android.app.Dialog
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.lomovskiy.android.lib.ui.EXTRA_RENDER_MODEL
import com.lomovskiy.android.lib.ui.R
import com.squareup.picasso.Picasso
import kotlinx.android.parcel.Parcelize
import java.io.File

class DialogShowImage : DialogFragment() {

    companion object {

        const val TAG = "DialogShowImage"

        @JvmStatic
        fun newInstance(config: Config): DialogShowImage {
            return DialogShowImage().apply {
                arguments = Bundle().apply {
                    putParcelable(EXTRA_RENDER_MODEL, config)
                }
            }
        }

    }

    private val config: Config
        get() = requireArguments().getParcelable(EXTRA_RENDER_MODEL)!!

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view: ImageView = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_show_image, null) as ImageView
        Picasso.get()
            .load(config.file)
            .into(view)
        return AlertDialog.Builder(requireContext())
                .setView(view)
                .create()
    }

    @Parcelize
    class Config(
        val file: File
    ) : Parcelable

}