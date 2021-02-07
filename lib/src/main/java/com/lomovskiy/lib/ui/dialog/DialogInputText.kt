package com.lomovskiy.lib.ui.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.os.Parcelable
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import androidx.annotation.StyleRes
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.google.android.material.textfield.TextInputLayout
import com.lomovskiy.lib.ui.*
import com.lomovskiy.lib.ui.EXTRA_RENDER_MODEL
import kotlinx.parcelize.Parcelize

class DialogInputText : DialogFragment(), DialogInterface.OnClickListener {

    private val eventsTarget: EventsTarget
        get() = when {
            (parentFragment is EventsTarget) -> parentFragment as EventsTarget
            (activity is EventsTarget) -> activity as EventsTarget
            else -> throw IllegalStateException("Nullable listener of DialogInputText")
        }

    private val renderModel: RenderModel
        get() = requireArguments().getParcelable(EXTRA_RENDER_MODEL)!!

    private lateinit var field: TextInputLayout

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view: View = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_input_text, null)
        setupView(view)
        val builder: AlertDialog.Builder
        if (renderModel.style == RES_UNDEFINED) {
            builder = AlertDialog.Builder(requireContext())
        } else {
            builder = AlertDialog.Builder(requireContext(), renderModel.style)
        }
        builder.setTitle(renderModel.title)
        builder.setView(view)
        builder.setPositiveButton(
                if (renderModel.positiveButtonLabel == RES_UNDEFINED) { android.R.string.ok } else { renderModel.positiveButtonLabel },
                this
        )
        return builder.create().apply {
            window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
        }
    }

    override fun onClick(dialog: DialogInterface, which: Int) {
        if (which == DialogInterface.BUTTON_POSITIVE) {
            eventsTarget.dialogInputTextPositiveButtonClicked(field.text())
        }
    }

    private fun setupView(parent: View) {
        field = parent.findViewById(R.id.field_text)

        field.editText().inputType = if (renderModel.inputType == RES_UNDEFINED) {
            InputType.TYPE_CLASS_TEXT
        } else {
            renderModel.inputType
        }

        if (renderModel.hint != RES_UNDEFINED) {
            field.setHint(renderModel.hint)
        }

        renderModel.text?.let { text: String ->
            field.setText(text)
            field.editText().setSelection(text.length)
        }

        if (renderModel.maxLength != RES_UNDEFINED) {
            field.counterMaxLength = renderModel.maxLength
            field.isCounterEnabled = true
        }

        if (renderModel.maxLines != RES_UNDEFINED) {
            field.editText().maxLines = renderModel.maxLines
        }
    }

    companion object {

        const val TAG = "DialogInputText"

        @JvmStatic
        fun newInstance(renderModel: RenderModel): DialogInputText {
            return DialogInputText().apply {
                arguments = Bundle().apply {
                    putParcelable(EXTRA_RENDER_MODEL, renderModel)
                }
            }
        }

    }

    interface EventsTarget {
        fun dialogInputTextPositiveButtonClicked(text: String)
    }

    @Parcelize
    class RenderModel @JvmOverloads constructor(
        val title: Int,
        val hint: Int = RES_UNDEFINED,
        val text: String? = null,
        val positiveButtonLabel: Int = RES_UNDEFINED,
        val maxLength: Int = RES_UNDEFINED,
        val maxLines: Int = RES_UNDEFINED,
        val inputType: Int = RES_UNDEFINED,
        @StyleRes val style: Int = RES_UNDEFINED
    ) : Parcelable

}
