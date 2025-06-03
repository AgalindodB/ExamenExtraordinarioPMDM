package com.example.examenextraordinario.data.repository

import com.example.examenextraordinario.data.model.User
import com.example.examenextraordinario.data.network.ApiService

/**
 * Hemos definido la clase "UserRepository" , para ser la encargada de la lógica de obtención de
 * datos que se soliciten a traves de las llamadas a la API.
 */
class UserRepository(private val api: ApiService) {
    suspend fun getUsers(): List<User> = api.getUsers()

}

