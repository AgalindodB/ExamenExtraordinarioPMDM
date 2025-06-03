package com.example.examenextraordinario.data.network

import com.example.examenextraordinario.data.model.User
import retrofit2.http.GET

/**
 * Aqui definimos la interfaz denominada "ApiService", que como dice bien su nombre, sera la
 * encargada de inciar el servicio "Retrofit"
 */
interface ApiService{
    @GET("users")
    suspend fun getUsers(): List<User>
}