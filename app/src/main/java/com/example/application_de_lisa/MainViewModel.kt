package com.example.application_de_lisa


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainViewModel : ViewModel() {

    private val apiKey = "b57151d36fecd1b693da830a2bc5766f"
    private val language = "fr-FR"


    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory()).build()


    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    private val api = retrofit.create(Api::class.java)

    val movies = MutableStateFlow<List<ModelMovies>>(listOf())
    val movieById = MutableStateFlow<ModelMovies?>(null)
    val series = MutableStateFlow<List<ModelSeries>>(listOf())
    val serieById = MutableStateFlow<ModelSeries?>(null)
    val acteurs = MutableStateFlow<List<ModelActeurs>>(listOf())
    val acteurById = MutableStateFlow<ModelActeurs?>(null)
    val collectionHorror = MutableStateFlow<List<Result>>(listOf())

    fun getMovies() {
        viewModelScope.launch {
            movies.value = api.lastmovies(apiKey, language).results

        }
    }

    fun getMovieById(id_movie: Int) {
        viewModelScope.launch {
            movieById.value = api.moviedetails(id_movie, apiKey, language)
        }
    }

    fun getSearchMovies(query: String) {
        viewModelScope.launch {
            movies.value = api.requestedmovies(apiKey, query).results
        }
    }

    fun getSeries() {
        viewModelScope.launch {
            series.value = api.lastseries(apiKey, language).results

        }
    }

    fun getSerieById(id_serie: Int) {
        viewModelScope.launch {
            serieById.value = api.seriedetails(id_serie, apiKey, language)
        }
    }

    fun getSearchSeries(query: String) {
        viewModelScope.launch {
            series.value = api.requestedseries(apiKey, query).results
        }
    }

    fun getActeurs() {
        viewModelScope.launch {
            acteurs.value = api.lastactors(apiKey, language).results

        }
    }

    fun getActeurById(id_acteur: Int) {
        viewModelScope.launch {
            acteurById.value = api.actordetails(id_acteur, apiKey, language)
        }
    }

    fun getSearchActeurs(query: String) {
        viewModelScope.launch {
            acteurs.value = api.requestedactor(apiKey, query).results
        }
    }

    fun getCollectionHorror () {
        viewModelScope.launch {
            collectionHorror.value = api.collection(apiKey,"horror", "fr").results
        }

    }
}
