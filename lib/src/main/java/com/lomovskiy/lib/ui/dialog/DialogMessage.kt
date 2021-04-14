package com.lomovskiy.lib.ui.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.lomovskiy.lib.ui.EXTRA_RENDER_MODEL
import kotlinx.parcelize.Parcelize

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
        val builder: AlertDialog.Builder
        if (renderModel.style != null) {
            builder = AlertDialog.Builder(requireContext())
        } else {
            builder = AlertDialog.Builder(requireContext(), renderModel.style!!)
        }
        builder.setTitle(renderModel.title)
        builder.setMessage(renderModel.message)
        builder.setPositiveButton(renderModel.positiveButtonText, this)
        if (renderModel.neutralButtonText != null) {
            builder.setNeutralButton(renderModel.neutralButtonText, this)
        }
        if (renderModel.negativeButtonText != null) {
            builder.setNegativeButton(renderModel.negativeButtonText, this)
        }
        return builder.create()
    }

    override fun onClick(dialog: DialogInterface, which: Int) {
        when (which) {
            DialogInterface.BUTTON_POSITIVE -> {
                eventsTarget.dialogMessagePositiveButtonClicked(renderModel.tag)
            }
            DialogInterface.BUTTON_NEGATIVE -> {
                eventsTarget.dialogMessageNegativeButtonClicked(renderModel.tag)
            }
            DialogInterface.BUTTON_NEUTRAL -> {
                eventsTarget.dialogMessageNeutralButtonClicked(renderModel.tag)
            }
        }
    }

    interface EventsTarget {
        fun dialogMessagePositiveButtonClicked(tag: String)
        fun dialogMessageNegativeButtonClicked(tag: String)
        fun dialogMessageNeutralButtonClicked(tag: String)
    }

    @Parcelize
    class RenderModel @JvmOverloads constructor(
        val tag: String,
        val title: String,
        val message: String,
        val positiveButtonText: String,
        val negativeButtonText: String? = null,
        val neutralButtonText: String? = null,
        val style: Int? = null
    ) : Parcelable

}
