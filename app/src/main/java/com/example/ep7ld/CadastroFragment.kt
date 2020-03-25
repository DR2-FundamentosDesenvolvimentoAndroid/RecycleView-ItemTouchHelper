package com.example.ep7ld


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.ep7ld.Model.Usuario
import com.example.ep7ld.ViewModel.UsuarioViewModel
import kotlinx.android.synthetic.main.fragment_cadastro.*

/**
 * A simple [Fragment] subclass.
 */
class CadastroFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cadastro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var usuarioViewModel : UsuarioViewModel? = null //ViewModelProviders.of()
        activity?.let {
            usuarioViewModel = ViewModelProviders.of(it)
                .get(UsuarioViewModel::class.java)
        }

        btnCadastrar.setOnClickListener {
            usuarioViewModel?.usuario = Usuario(
                edtTxtEmail.text.toString(), edtTxtSenha.text.toString()
            )
            findNavController().navigate(R.id.acessoFragment)
        }


    }


}
