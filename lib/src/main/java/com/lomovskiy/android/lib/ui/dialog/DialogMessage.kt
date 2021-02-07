package com.lomovskiy.android.lib.ui.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.os.Parcelable
import androidx.annotation.StringRes
import androidx.annotation.StyleRes
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.lomovskiy.android.lib.ui.EXTRA_RENDER_MODEL
import com.lomovskiy.android.lib.ui.RES_UNDEFINED
import kotlinx.android.parcel.Parcelize

class DialogMessage : DialogFragment(), DialogInterface.OnClickListener {

    companion object {

        @JvmStatic
        fun newInstance(renderModel: RenderModel): DialogMessage {
            return DialogMessage().apply {
                arguments = Bundle().apply {
                    putParcelable(EXTRA_RENDER_MODEL, renderModel)
                }
            }
        }

    }

    private val renderModel: RenderModel
        get() = requireArguments().getParcelable(EXTRA_RENDER_MODEL)!!

    private val eventsTarget: EventsTarget
        get() = when {
            parentFragment is EventsTarget -> parentFragment as EventsTarget
            activity is EventsTarget -> activity as EventsTarget
            else -> throw IllegalStateException("Events target is null")
        }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = if (renderModel.style == RES_UNDEFINED) {
            AlertDialog.Builder(requireContext())
        } else {
            AlertDialog.Builder(requireContext(), renderModel.style)
        }
        builder.setTitle(renderModel.title)
        builder.setMessage(renderModel.message)
        builder.setPositiveButton(renderModel.positiveButtonText, this)
        if (renderModel.neutralButtonText != RES_UNDEFINED) {
            builder.setNeutralButton(renderModel.neutralButtonText, this)
        }
        if (renderModel.negativeButtonText != RES_UNDEFINED) {
            builder.setNegativeButton(renderModel.negativeButtonText, this)
        }
        return builder.create()
    }

    override fun onClick(dialog: DialogInterface, which: Int) {
        when (which) {
            DialogInterface.BUTTON_POSITIVE -> {
                eventsTarget.dialogSimpleMessagePositiveButtonClicked(renderModel.tag)
            }
            DialogInterface.BUTTON_NEGATIVE -> {
                eventsTarget.dialogSimpleMessageNegativeButtonClicked(renderModel.tag)
            }
            DialogInterface.BUTTON_NEUTRAL -> {
                eventsTarget.dialogSimpleMessageNeutralButtonClicked(renderModel.tag)
            }
        }
    }

    interface EventsTarget {
        fun dialogSimpleMessagePositiveButtonClicked(tag: String)
        fun dialogSimpleMessageNegativeButtonClicked(tag: String)
        fun dialogSimpleMessageNeutralButtonClicked(tag: String)
    }

    @Parcelize
    class RenderModel @JvmOverloads constructor(
        val tag: String,
        @StringRes val title: Int,
        @StringRes val message: Int,
        @StringRes val positiveButtonText: Int,
        @StringRes val negativeButtonText: Int = RES_UNDEFINED,
        @StringRes val neutralButtonText: Int = RES_UNDEFINED,
        @StyleRes val style: Int = RES_UNDEFINED
    ) : Parcelable

}
