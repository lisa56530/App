package com.example.application_de_lisa


import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("trending/movie/week")
    suspend fun
            lastmovies(
            @Query("api_key") apiKey: String,
            @Query("language") language: String)
    : ModelListMovies

    @GET("movie/{id}?append_to_response=credits")
    suspend fun moviedetails(
        @Path("id") id_film: Int,
        @Query("api_key")  api_key: String,
        @Query("language") language: String)
    : ModelMovies

    @GET("search/movie")
suspend fun
        requestedmovies(
        @Query("api_key")  api_key: String,
        @Query("language") language: String,
        @Query("query") query: String)
    : ModelListMovies

}
