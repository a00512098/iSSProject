package com.example.issproject.datasource

import com.example.issproject.datasource.ResponseObserver.ResponseCallback
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ResponseRepo {
    fun getResponse(callback: ResponseCallback, lat: String = "55", lon: String = "120") {
        RetrofitHelper.getResponseObservable(lat, lon)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(ResponseObserver(callback))
    }
}