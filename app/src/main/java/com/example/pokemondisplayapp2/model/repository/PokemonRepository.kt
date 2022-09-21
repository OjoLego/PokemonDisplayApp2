package com.example.pokemondisplayapp2.model.repository

import androidx.lifecycle.LiveData
import com.example.pokemondisplayapp2.model.data.PokemonPojo
import com.example.pokemondisplayapp2.model.data.PostData
import com.example.pokemondisplayapp2.model.datasource.PokemonRetrofit
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import okhttp3.MultipartBody

object PokemonRepository {

    var task: CompletableJob? = null

    fun getAllPokemon(): LiveData<PokemonPojo>{
        task = Job()
        return object : LiveData<PokemonPojo>() {
            override fun onActive() {
                super.onActive()
                task?.let {
                    CoroutineScope(IO + it).launch {
                        val allPokemon = PokemonRetrofit.pokeRetrofit.getAllPokemon()

                        withContext(Main){
                            value = allPokemon
                            it.complete()
                        }
                    }
                }
            }
        }
    }

    fun uploadImage(img: MultipartBody.Part):LiveData<PostData>{

        task = Job()

        return object : LiveData<PostData>(){
            override fun onActive() {
                super.onActive()
                task?.let { task->
                    CoroutineScope(Main + task).launch {
                        val postResponse = PokemonRetrofit.pokeRetrofit2.uploadToServer(img)

                        withContext(Main){
                            value = postResponse

                            task.complete()
                        }
                    }
                }
            }
        }

    }

    fun cancelJob(){
        task?.cancel()
    }

}