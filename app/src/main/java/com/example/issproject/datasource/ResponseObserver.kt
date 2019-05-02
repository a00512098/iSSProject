package com.example.issproject.datasource

import com.example.issproject.model.ApiResponse
import com.example.issproject.model.Response
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class ResponseObserver(val responseCallback: ResponseCallback) : Observer<ApiResponse> {

    private lateinit var response: ApiResponse


    override fun onComplete() {
        responseCallback.onSuccess(response)
    }

    override fun onSubscribe(d: Disposable) {
    }

    override fun onNext(response: ApiResponse) {
        this.response = response
    }

    override fun onError(e: Throwable) {
        responseCallback.onError(e)
    }

    interface ResponseCallback {
        fun onSuccess(apiResponse: ApiResponse)
        fun onError(e: Throwable)
    }

}