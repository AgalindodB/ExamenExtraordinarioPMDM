package com.example.examenextraordinario.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examenextraordinario.data.model.User
import com.example.examenextraordinario.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * La clase "UserViewModel" sriva para gestionar el estado y mostrar los datos a traves de la vista.
 */
class UserViewModel(private val repository: UserRepository) : ViewModel() {

    // Definimos una de las vavriable de la clase con un "underscore" (_) para poder diferenciar
    // nuestras variables una de otra y no existan problemas de tipo
    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            try {
                _users.value = repository.getUsers()
            } catch (e:Exception) {
                // Aqui podría manejar el error en caso de que se produjese una "Exception" pero
                // creo que de moemento asi estara bien
            }
        }
    }

}


