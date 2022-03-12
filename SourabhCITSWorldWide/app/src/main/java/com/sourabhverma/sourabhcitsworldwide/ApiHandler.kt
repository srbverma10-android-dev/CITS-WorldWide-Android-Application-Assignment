package com.sourabhverma.sourabhcitsworldwide

import okhttp3.MultipartBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiHandler {

    @Headers("x-rapidapi-key: 6b3049d4c7msha33389ae9fb1f19p1fe42bjsnb10b3dcae214")
    @GET("news")
    fun newsHomeApi(
    ): Call<HomeResponeModel?>?

    companion object{
        operator fun invoke() : ApiHandler {
            return Retrofit.Builder()
                .baseUrl("https://bing-news-search1.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiHandler::class.java)
        }
    }

}