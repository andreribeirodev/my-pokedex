package com.andreribeiro.pokedextraining.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.andreribeiro.pokedextraining.api.RetrofitInstance
import com.andreribeiro.pokedextraining.databinding.ActivityPokemonlistBinding
import com.andreribeiro.pokedextraining.model.PokemonListResponse
import com.andreribeiro.pokedextraining.repository.PokemonRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonListActivity : AppCompatActivity() {

    private val binding: ActivityPokemonlistBinding by lazy {
        ActivityPokemonlistBinding.inflate(layoutInflater)
    }
    private val pokemonService by lazy {
        RetrofitInstance.pokemonService
    }
    private val pokemonRepository: PokemonRepository by lazy {
        PokemonRepository(pokemonService)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getPokemonsList()
    }

    private fun getPokemonsList() {
        pokemonRepository.getPokemonsList(150).enqueue(object : Callback<PokemonListResponse> {
            override fun onResponse(
                call: Call<PokemonListResponse>,
                response: Response<PokemonListResponse>
            ) {
                val result = response.body()
            }

            override fun onFailure(call: Call<PokemonListResponse>, t: Throwable) {
                println("nonono")
            }
        })
    }
}
