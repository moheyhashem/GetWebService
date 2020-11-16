package com.example.getwebservice

import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("version")
    fun getPost(): Call<GetPostResponse>
}