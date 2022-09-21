package com.example.pokemondisplayapp2.view

import android.content.ContentValues.TAG
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemondisplayapp2.databinding.CardviewBinding
import com.example.pokemondisplayapp2.model.data.Results
import com.example.pokemondisplayapp2.util.FetchData
import com.squareup.picasso.Picasso

private const val TAG = "PokemonViewHolder"
class PokemonViewHolder (private val binding: CardviewBinding):RecyclerView.ViewHolder(binding.root){
    val pokemonName = binding.pokemonName
    val pokemonImage = binding.pokemonImage
    val displayId = binding.displayId

    fun bind(pokemon:Results){
        Log.d(TAG,pokemon.name)
        pokemonName.setText(pokemon.name)
        val id = FetchData.getId(pokemon.url)
        Picasso.get().load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${id}.png").into(pokemonImage)
        displayId.setText(id)
    }
}