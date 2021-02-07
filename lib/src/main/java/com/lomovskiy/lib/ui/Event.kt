package com.lomovskiy.lib.ui

open class Event<out T>(private val content: T) {

    var isHandled = false
        private set

    fun getContent(): T? {
        if (!isHandled) {
            isHandled = true
            return content
        } else {
            return null
        }
    }

    fun peekContent(): T = content

}
