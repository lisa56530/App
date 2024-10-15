package com.example.application_de_lisa

interface Api {
    @GET("trending/movie/week")
    suspend fun lastmovies(@Query("api_key") api_key: String,
                           @Query("api_key") api_key: String): listeFilm
}

annotation class GET(val value: String)

annotation class Query(val value: String)
