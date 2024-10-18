import android.graphics.ColorSpace
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.application_de_lisa.Api
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainViewModel : ViewModel() {

    private val apiKey = "b57151d36fecd1b693da830a2bc5766f"
    private val language = "fr-FR"

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    private val api = retrofit.create(Api::class.java)

    // Assurez-vous que le type de données correspond à ce que vous attendez de l'API
    val movies = MutableStateFlow<List<ColorSpace.Model>>(listOf())

    fun getMovies() {
        viewModelScope.launch {
            try {
                // Assurez-vous que la méthode lastmovies accepte les bons paramètres
                movies.value = listOf(api.lastmovies(apiKey, language))
            } catch (e: Exception) {
                // Gérer l'erreur ici (logging, afficher un message, etc.)
            }
        }
    }
}
