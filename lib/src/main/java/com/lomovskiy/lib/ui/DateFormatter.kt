@file:Suppress("NOTHING_TO_INLINE")

package com.lomovskiy.lib.ui

import org.threeten.bp.Instant
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneId
import org.threeten.bp.format.DateTimeFormatter

class DateFormatter {

    companion object {

        val FORMAT_1: DateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        val FORMAT_2: DateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")

    }

    inline fun convertTimestampToLocalDateTime(timestamp: Long): LocalDateTime {
        return Instant.ofEpochSecond(timestamp).atZone(ZoneId.systemDefault()).toLocalDateTime()
    }

    /**
     * All timestaps in seconds!!!
     */
    inline fun convertTimestampToString(source: Long, formatter: DateTimeFormatter): String {
        return formatter.format(convertTimestampToLocalDateTime(source))
    }

    /**
     * All timestaps in seconds!!!
     */
    inline fun convertDateTimeStringToTimestamp(source: String): Long {
        return Instant.parse(source).epochSecond
    }

}
