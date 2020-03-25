package com.example.ep7ld.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.ep7ld.Model.Usuario
import com.example.ep7ld.R
import kotlinx.android.synthetic.main.usuario_recycle.view.*

/*
//class UsuarioAdapter (
//    val usuarios : List<Usuario> //,
//    //val callback : (Usuario) -> Unit
//)    : RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder>(){
*/

// Adapter que recebe uma lista.
class UsuarioAdapter (
    val usuarios : List<Usuario>
)    : RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder>(){

    // ViewHolder: Captura os componentes do layout nas propriedades
    class UsuarioViewHolder(view : View)
        : RecyclerView.ViewHolder(view) {
        val campoNome = view.txtVwNome
        val campoSobrenome = view.txtVwSobrenome
        val campoTelefone = view.txtVwTelefone
    }

    // Anexa o item_layout a Recycler
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : UsuarioViewHolder {
        // item_layout
        val v = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.usuario_recycle, // Representa um item
                parent,false
            )
        val usuarioViewHolder = UsuarioViewHolder(v)
        /*
        // Lista
        // card: Nome 1, imagem 1
        // card: Nome 2, imagem 2
//        usuarioViewHolder.itemView.setOnClickListener {
//            val usuario = usuarios[usuarioViewHolder.adapterPosition]
//            usuario.telefone
            //Toast.makeText(...).show
            //...
//        }
         */
        return usuarioViewHolder
    }

    // Quntd de itens para exibição
    override fun getItemCount(): Int = usuarios.size

    // Bind entre as propriedades do ViewHolder com as do Model
    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val usuario = usuarios[position]
        holder.campoNome.text = usuario.nome
        holder.campoSobrenome.text = usuario.sobrenome
        holder.campoTelefone.text = usuario.telefone
    }
}