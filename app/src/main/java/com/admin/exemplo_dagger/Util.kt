package com.admin.exemplo_dagger

import android.annotation.SuppressLint
import android.net.ParseException
import java.text.SimpleDateFormat

class Util {

    @Throws(ParseException::class) fun formatDate(dateEntry: String): String {
        @SuppressLint("SimpleDateFormat")
        val sdfInput = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        @SuppressLint("SimpleDateFormat")
        val sdfOutput = SimpleDateFormat("dd/MM/yyyy HH:mm")

        val d = sdfInput.parse(dateEntry)
        val dateFormated = sdfOutput.format(d)

        return dateFormated + "h"
    }
}