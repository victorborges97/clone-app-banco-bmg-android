package com.borges.clonebmg


import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.borges.clonebmg.R.*


class MainActivity : AppCompatActivity() {
    var textViewEsconder: TextView? = null
    var textViewSaldo: TextView? = null
    var imageView: ImageView? = null
    var toolbar_iconmenu: ImageView? = null
    var toolbar_iconperfil: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        //Menu da Toolbar
        toolbar_iconmenu = findViewById(id.toolbar_icon_menu)
        toolbar_iconperfil = findViewById(id.toolbar_icon_perfil)

        //Menu do CardView de Saldo
        textViewEsconder = findViewById(id.info_text_toqueesconder)
        textViewSaldo = findViewById(id.info_text_saldo)
        imageView = findViewById(id.icon_refresh_saldo)

        textViewEsconder?.setOnClickListener {
            esconderSaldo()
        }
        imageView?.setOnClickListener {
            val valorinicial = 1
            val valorrefresh = 500
            if(textViewSaldo?.hint == "R$ 500,00"){
                hintDelay(valorinicial)
            } else {
                hintDelay(valorrefresh)
            }
        }
        toolBarActions()
    }

    private fun hintDelay(i: Int) {
        textViewSaldo?.hint = "R$ $i,00"
    }

    private fun toolBarActions() {

        toolbar_iconmenu?.setOnClickListener {
            Toast.makeText(this, "Abrir menu lateral", Toast.LENGTH_LONG).show()
        }

        toolbar_iconperfil?.setOnClickListener {
            Toast.makeText(this, "Abrir Perfil", Toast.LENGTH_LONG).show()
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