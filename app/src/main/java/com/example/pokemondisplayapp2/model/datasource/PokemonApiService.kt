package com.example.pokemondisplayapp2.model.datasource

import com.example.pokemondisplayapp2.model.data.PokemonPojo
import retrofit2.http.GET

interface PokemonApiService {
    @GET("pokemon")
    suspend fun getAllPokemon():PokemonPojo
}