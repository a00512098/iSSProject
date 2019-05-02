package com.example.issproject.datasource

import com.example.issproject.model.ApiResponse
import com.example.issproject.model.Response
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object RetrofitHelper {

    private const val BASE_URL = "http://api.open-notify.org/"
    private const val API_PATH = "iss-pass.json?"
    private const val LATITUDE = "lat"
    private const val LONGITUDE = "lon"

    private val retrofit: Retrofit
        get() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    private fun createResponseInterface(): ObservableInterface {
        return retrofit.create(ObservableInterface::class.java)
    }

    fun getResponseObservable(lat: String, lon: String): Observable<ApiResponse> {
        return createResponseInterface().getResponse(lat, lon)
    }

    interface ObservableInterface {
        @GET(API_PATH)
        fun getResponse(
            @Query(LATITUDE) latitude: String,
            @Query(LONGITUDE) longitude: String
        ): Observable<ApiResponse>
    }
}
