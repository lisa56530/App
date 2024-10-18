package com.example.application_de_lisa

import android.graphics.ColorSpace

interface Api {
    @GET("trending/movie/week")
    suspend fun lastmovies(@Query("api_key") apiKey: String, language: String): ColorSpace.Model
}

annotation class GET(val value: String)

annotation class Query(val value: String)

