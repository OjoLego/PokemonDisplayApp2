package com.example.pokemondisplayapp2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.pokemondisplayapp2.model.data.PokemonPojo
import com.example.pokemondisplayapp2.model.data.PostData
import com.example.pokemondisplayapp2.model.repository.PokemonRepository
import okhttp3.MultipartBody

class MainViewModel :ViewModel(){

    fun getData(): LiveData<PokemonPojo>{
        return PokemonRepository.getAllPokemon()
    }

    fun uploadImage(img: MultipartBody.Part): LiveData<PostData>{
        return PokemonRepository.uploadImage(img)
    }

    fun cancelJob(){
        PokemonRepository.cancelJob()
    }

}