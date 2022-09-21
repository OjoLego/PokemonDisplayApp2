package com.example.pokemondisplayapp2.model.datasource

import com.example.pokemondisplayapp2.model.data.PostData
import okhttp3.MultipartBody
import retrofit2.http.Part

interface PostService {
    suspend fun uploadToServer(@Part img: MultipartBody.Part): PostData
}