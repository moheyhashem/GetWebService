package com.example.getwebservice

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun loadData(view: View) {

        val retrofit = Retrofit.Builder()
            .baseUrl("http://3.131.229.146/api/min-version/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        val api = retrofit.create(ApiService::class.java)

        val post: Call<GetPostResponse> = api.getPost()

        post.enqueue(object : Callback<GetPostResponse>{
            override fun onFailure(call: Call<GetPostResponse>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<GetPostResponse>,
                response: Response<GetPostResponse>
            ) {
                post_version.text = response.body()?.value.toString()
            }

        })



    }

}

