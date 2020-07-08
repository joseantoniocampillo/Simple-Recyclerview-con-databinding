package dev.campi.listadatabinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _modelos = MutableLiveData<List<Modelo>>()
    val modelos : LiveData<List<Modelo>> = _modelos

    init {
        _modelos.value = listOf(
            Modelo(1L, "modelo 1"),
            Modelo(2L, "modelo 2"),
            Modelo(3L, "modelo 3")
        )
    }
}