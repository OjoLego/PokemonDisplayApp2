package com.example.pokemondisplayapp2.model.datasource

import com.example.pokemondisplayapp2.util.Const
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object PokemonRetrofit {

    private val retrofit:Retrofit.Builder by lazy {
        Retrofit.Builder().baseUrl(Const.BASE_URL).addConverterFactory(GsonConverterFactory.create())
    }
    private val retrofit2:Retrofit.Builder by lazy {
        Retrofit.Builder().baseUrl(Const.POST_URL).addConverterFactory(GsonConverterFactory.create())
    }
    val pokeRetrofit:PokemonApiService by lazy {
        retrofit.build().create(PokemonApiService::class.java)
    }
    val pokeRetrofit2:PostService by lazy {
        retrofit2.build().create(PostService::class.java)
    }
}