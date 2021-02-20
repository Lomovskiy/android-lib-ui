package com.lomovskiy.lib.ui

open class Command<out T>(
    private val content: T,
    private val isPersistent: Boolean = false
) {

    private var isHandled = false

    fun get(): T? {
        if (!isHandled) {
            if (!isPersistent) {
                isHandled = true
            }
            return content
        } else {
            return null
        }
    }

    fun take(): T {
        return content
    }

}
