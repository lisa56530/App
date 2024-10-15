package com.example.application_de_lisa

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val api_key = b57151d36fecd1b693da830a2bc5766f
    val language =

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build();

    val api = retrofit.create(Api::class.java)
    // à partir de là, on peut appeler api.lastMovies(...)

    val movies = MutableStateFlow<List<Model>>(listOf())

    fun getMovies() {
        viewModelScope.launch {
            movies.value = api.lastmovies(api_key, language)
        }
    }
}
