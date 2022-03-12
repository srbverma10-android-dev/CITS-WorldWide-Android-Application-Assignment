package com.sourabhverma.sourabhcitsworldwide.ui.home

import com.sourabhverma.sourabhcitsworldwide.ApiHandler
import com.sourabhverma.sourabhcitsworldwide.HomeResponeModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repo {

    private val apiHandler: ApiHandler = ApiHandler()

    fun newsHomeApi(onResult: (HomeResponeModel?)->Unit){
        apiHandler.newsHomeApi()?.enqueue(object :
            Callback<HomeResponeModel?> {
            override fun onResponse(
                call: Call<HomeResponeModel?>,
                response: Response<HomeResponeModel?>
            ) {
                if (response.code() == 200){
                    onResult(response.body())
                } else {
                    onResult(null)
                }
            }

            override fun onFailure(call: Call<HomeResponeModel?>, t: Throwable) {
                onResult(null)
            }

        })
    }

}