package com.example.examenextraordinario

import com.example.examenextraordinario.data.repository.UserRepository
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.examenextraordinario.data.network.ApiService
import com.example.examenextraordinario.ui.navigation.AppNavGraph
import com.example.examenextraordinario.viewmodel.UserViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializamos Retrofit y el ViewModel manualmente (sin Hilt por simplicidad)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)
        val repository = UserRepository(apiService)
        val userViewModel = UserViewModel(repository)

        setContent {
            val navController = rememberNavController()

            Surface(color = MaterialTheme.colorScheme.background) {
                AppNavGraph(
                    navController = navController,
                    viewModel = userViewModel
                )
            }
        }
    }
}


