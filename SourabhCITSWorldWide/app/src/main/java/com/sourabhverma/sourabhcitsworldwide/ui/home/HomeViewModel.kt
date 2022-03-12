package com.sourabhverma.sourabhcitsworldwide.ui.home

import android.content.Context
import android.graphics.Bitmap
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sourabhverma.sourabhcitsworldwide.HomeResponeModel
import java.io.File

class HomeViewModel : ViewModel() {

    private val repo : Repo = Repo()

    private var newsApiLiveData : MutableLiveData<HomeResponeModel> = MutableLiveData()

    fun newsApiHome(){
        repo.newsHomeApi(){
            if (it != null){
                newsApiLiveData.postValue(it)
            }
        }
    }

    fun getNewsHomeApi() : MutableLiveData<HomeResponeModel>{
        return newsApiLiveData
    }
}