package com.example.ep7ld


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.ep7ld.ViewModel.UsuarioViewModel
import kotlinx.android.synthetic.main.fragment_acesso.*

/**
 * A simple [Fragment] subclass.
 */
class AcessoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_acesso, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var usuarioViewModel : UsuarioViewModel? = null
        activity?.let {
            usuarioViewModel = ViewModelProviders.of(it)
                    .get(UsuarioViewModel::class.java)
        }
        var usuario = usuarioViewModel!!.usuario
        if (usuario != null && !usuario!!.email.isNullOrBlank()){
            edtTextAcessoEmail.setText(usuario!!.email.toString())
        }

        btnAcessar.setOnClickListener {
            if (
                edtTextAcessoEmail.text.toString().compareTo(usuario!!.email) == 0 &&
                edtTextAcessoSenha.text.toString().equals(usuario!!.senha)
                    ){
                startActivity(Intent(activity, AppActivity::class.java))
            } else {
                Toast.makeText(
                    activity?.baseContext,
                    "Usuário inválido!",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        btnCadastro.setOnClickListener {
            findNavController()
                .navigate(R.id.cadastroFragment)
        }
    }


}
