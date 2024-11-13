package com.example.application_de_lisa


import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("trending/movie/week")
    suspend fun
            lastmovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    )
            : ModelListMovies

    @GET("movie/{id}?append_to_response=credits")
    suspend fun moviedetails(
        @Path("id") id_movie: Int,
        @Query("api_key") api_key: String,
        @Query("language") language: String
    )
            : ModelMovies

    @GET("search/movie")
    suspend fun
            requestedmovies(
        @Query("api_key") api_key: String,
        @Query("query") query: String
    )
            : ModelListMovies

    @GET("trending/tv/week")
    suspend fun
            lastseries(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    )
            : ModelListSeries

    @GET("tv/{id}?append_to_response=credits")
    suspend fun seriedetails(
        @Path("id") id_serie: Int,
        @Query("api_key") api_key: String,
        @Query("language") language: String
    )
            : ModelSeries

    @GET("search/tv")
    suspend fun

            requestedseries(
        @Query("api_key") api_key: String,
        @Query("query") query: String
    )
            : ModelListSeries

    @GET("trending/person/week")
    suspend fun
            lastactors(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    )
            : ModelListActor

    @GET("person/{id}?append_to_response=credits")
    suspend fun actordetails(
        @Path("id") id_acteur: Int,
        @Query("api_key") api_key: String,
        @Query("language") language: String
    )

            : ModelActeurs

    @GET("search/person")
    suspend fun
            requestedactor(
        @Query("api_key") api_key: String,
        @Query("query") query: String
    )
            : ModelListActor


    @GET("search/collection?")
    suspend fun collection(
        @Query("api_key") api_key: String,
        @Query("query") query:String,
        @Query("language") language: String
    )
    : collections
}

