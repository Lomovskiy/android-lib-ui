package com.lomovskiy.lib.ui.sample

import android.os.Bundle
import android.text.InputType
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.lomovskiy.lib.ui.dialog.DialogInputText
import com.lomovskiy.lib.ui.showDialog

class MainActivity : AppCompatActivity(), DialogInputText.EventsTarget {

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        button.setOnClickListener {
            showDialog(
                    DialogInputText.TAG,
                    DialogInputText.newInstance(
                            DialogInputText.RenderModel(
                                R.string.app_name,
                                R.string.app_name,
                                    "text",
                                    android.R.string.cancel,
                                    500,
                                    4,
                                    InputType.TYPE_CLASS_PHONE
                            )
                    )
            )
        }
    }

    override fun dialogInputTextPositiveButtonClicked(text: String) {

    }

}
