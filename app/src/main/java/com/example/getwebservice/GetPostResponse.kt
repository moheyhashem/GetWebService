package com.example.getwebservice


import com.google.gson.annotations.SerializedName

data class GetPostResponse(
    @SerializedName("value")
    val value: Int

)