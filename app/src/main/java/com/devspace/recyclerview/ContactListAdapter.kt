package com.devspace.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
//Adaptação entre o data class e o item_list layout
class ContactListAdapter:
    ListAdapter<Contact,ContactListAdapter.ContactViewHolder>(ContactDiffUtils()) {
    //criar um view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ContactViewHolder(view)
    }
    // bind = atrelar o dado com a UI views
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact =getItem(position)
        holder.bind(contact)
    }
    // view holder = view que segura os dados
    class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val tvName = view.findViewById<TextView>(R.id.tv_name)
        private val tvPhone = view.findViewById<TextView>(R.id.tv_phone)
        private val image = view.findViewById<ImageView>(R.id.image)

        fun bind(contact: Contact){
            tvName.text = contact.name
            tvPhone.text = contact.phone
            image.setImageResource(contact.icon)
        }

    }
}
    // RecyclerView é uma lista que faz a reciclagem dos itens para garantir que não estamos consumindo muita memória do aparelho
    // compara a diferença quando nossa lista é atualizada
    class ContactDiffUtils : DiffUtil.ItemCallback<Contact>(){
        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem.name == newItem.name
        }

    }

