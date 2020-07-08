package dev.campi.listadatabinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.campi.listadatabinding.databinding.ItemModeloLayoutBinding

class CustomListAdapter (private val onClickListener : OnClickListener) :
    ListAdapter<Modelo, CustomListAdapter.ModeloViewHolder>(DiffCallback) {

    class ModeloViewHolder(private val binding: ItemModeloLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(modelo: Modelo) {
            binding.modelo = modelo
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Modelo>() {
        override fun areItemsTheSame(oldItem: Modelo, newItem: Modelo): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Modelo, newItem: Modelo): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ModeloViewHolder {
        return ModeloViewHolder(ItemModeloLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ModeloViewHolder, position: Int) {
        val accion = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(accion)
        }
        holder.bind(accion)
    }

    class OnClickListener(val clickListener: (accion: Modelo) -> Unit) {
        fun onClick(accion: Modelo) = clickListener(accion)
    }

}