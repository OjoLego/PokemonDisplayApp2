package com.example.pokemondisplayapp2.model.data

data class PokemonPojo(
    val count:Int,
    val next:String?,
    val previous:String?,
    val results:ArrayList<Results>
){

}
