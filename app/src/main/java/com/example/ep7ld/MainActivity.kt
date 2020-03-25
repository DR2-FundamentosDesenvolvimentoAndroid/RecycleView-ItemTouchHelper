package com.example.ep7ld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.ep7ld.Model.Usuario
import com.example.ep7ld.ViewModel.UsuarioViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var usuario = Usuario(
//            R.drawable.ic_home_black_24dp,
//            "thi@go.com", "98765421"
//        )
//
//        usuario.imagem = R.drawable.ic_notifications_black_24dp

        var usuarioViewModel = ViewModelProviders.of(this)
                                    .get(UsuarioViewModel::class.java)

    }
}
