package com.example.pokemondisplayapp2.model.data

import com.example.pokemondisplayapp2.model.data.Payload

data class PostData(
  val message:String,
  val payload: Payload,
  val status:Int
){

}
