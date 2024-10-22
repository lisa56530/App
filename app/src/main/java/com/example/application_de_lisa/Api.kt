package com.example.application_de_lisa


import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("trending/movie/week")
    suspend fun lastmovies(@Query("api_key") apiKey: String, @Query("language") language: String): ModelListMovies
}



