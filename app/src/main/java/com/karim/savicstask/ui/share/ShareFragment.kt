package com.karim.savicstask.ui.share

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.karim.savicstask.R

class ShareFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_share, container, false)
        callIntent()
        return root
    }

    private fun callIntent() {
        try {
            val txt = " i didi good. i like it!".trimIndent()
            val sendEmail = Intent(Intent.ACTION_SEND)
            sendEmail.data = Uri.parse("mailto:")
            sendEmail.type = "message/rfc822"
            sendEmail.putExtra(Intent.EXTRA_EMAIL, "myandguestuser@gmail.com")
            sendEmail.putExtra(Intent.EXTRA_SUBJECT, "Savics Android test")
            sendEmail.putExtra(Intent.EXTRA_TEXT, txt)
            startActivity(sendEmail)
        } catch (e: Exception) {

        }
    }


}