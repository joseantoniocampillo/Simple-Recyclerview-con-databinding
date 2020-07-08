package dev.campi.listadatabinding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("datos")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Modelo>?) {
    val adapter = recyclerView.adapter as CustomListAdapter
    adapter.submitList(data)
}

