package com.mobile.duduck.service

import com.mobile.duduck.model.Subscription
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("/subscriptions")
    suspend fun getAllSubscriptions(): List<Subscription>

    companion object {

        private val apiService: ApiService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(ApiService::class.java)
        }

        fun getInstance(): ApiService {
            return apiService
        }

    }

}