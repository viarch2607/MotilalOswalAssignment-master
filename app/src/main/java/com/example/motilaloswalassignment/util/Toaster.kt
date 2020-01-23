package com.example.motilaloswalassignment.util

import android.content.Context
import android.graphics.PorterDuff
import android.widget.TextView
import androidx.core.content.ContextCompat



object Toaster {
    fun show(context: Context, text: String) {
        val toast = android.widget.Toast.makeText(context, text, android.widget.Toast.LENGTH_LONG)
        toast.view.background.setColorFilter(
            ContextCompat.getColor(context, android.R.color.white), PorterDuff.Mode.SRC_IN
        )
        val textView = toast.view.findViewById(android.R.id.message) as TextView
        textView.setTextColor(ContextCompat.getColor(context, android.R.color.black))
        toast.show()
    }

}