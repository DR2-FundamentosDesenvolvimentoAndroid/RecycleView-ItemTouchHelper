package com.example.ep7ld.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ep7ld.Adapter.UsuarioAdapter
import com.example.ep7ld.Model.Usuario
import com.example.ep7ld.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    var iteracao = 1

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(this, Observer {
//            textView.text = it
//            // Qualquer coisa!!
//        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var usuarios = mutableListOf(
            Usuario("thi@go.com", "654654654", "Thiago", "Aguiar", "(21)99999-9999"),
            Usuario("thi@go.com", "654654654", "Paulo", "Shou", "(21)99999-9999"),
            Usuario("thi@go.com", "654654654", "Paula", "Silva", "(21)99999-9999"),
            Usuario("thi@go.com", "654654654", "Marcus", "Lopes", "(21)99999-9999"),
            Usuario("thi@go.com", "654654654", "Higor", "Souza", "(21)99999-9999"),
            Usuario("thi@go.com", "654654654", "Higor", "Sousa", "(21)99999-9999")
        )

        var usuarioAdapter = UsuarioAdapter(usuarios)
        rcyVwHome.adapter = usuarioAdapter
        rcyVwHome.layoutManager = LinearLayoutManager(context)

        fab.setOnClickListener{
            var usuarioNovo = Usuario("will$iteracao@email.com","111111", "Willian$iteracao", "Nasc","(21$iteracao)98888-8888" )
            usuarios.add(usuarioNovo)
            usuarioAdapter.notifyItemInserted(usuarios.lastIndex)
            rcyVwHome.scrollToPosition(usuarios.lastIndex)
            iteracao++
        }

        val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                usuarios.removeAt(position)
                usuarioAdapter.notifyItemRemoved(position)
            }

        })

        itemTouchHelper.attachToRecyclerView(rcyVwHome)

    }

    // Parametro de entra -> Usuario
    // Retorno -> Unit
    fun callbackItem(usuario : Usuario) {
        Toast.makeText(context, usuario.email, Toast.LENGTH_LONG).show()
    }
}