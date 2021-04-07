package com.borges.clonebmg

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible


class MainActivity : AppCompatActivity() {
    var textViewEsconder: TextView? = null
    var textViewSaldo: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewEsconder = findViewById(R.id.info_text_toqueesconder)
        textViewSaldo = findViewById(R.id.info_text_saldo)

        textViewEsconder?.setOnClickListener {
            esconderSaldo()
        }
    }

    override fun onStart() {
        super.onStart()
        esconderSaldo()
    }

    private fun esconderSaldo() {
        textViewSaldo?.isVisible = textViewSaldo?.visibility != View.VISIBLE
        if(textViewSaldo?.visibility != View.VISIBLE) {
            textViewEsconder?.hint = "Toque para mostrar"
        } else {
            textViewEsconder?.hint = "Toque para esconder"
        }
    }

}