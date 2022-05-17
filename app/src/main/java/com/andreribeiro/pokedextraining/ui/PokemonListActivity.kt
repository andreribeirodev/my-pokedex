package com.andreribeiro.pokedextraining.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.andreribeiro.pokedextraining.api.iPokemonApiClient
import com.andreribeiro.pokedextraining.databinding.ActivityPokemonlistBinding
import com.andreribeiro.pokedextraining.model.PokemonListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonListActivity : AppCompatActivity() {

    private val binding: ActivityPokemonlistBinding by lazy {
        ActivityPokemonlistBinding.inflate(layoutInflater)
    }
    private val pokemonService by lazy {
        iPokemonApiClient.pokemonService
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getPokemonList()
    }

    private fun getPokemonList() {
        pokemonService.getPokemonsFromApi().enqueue(object : Callback<PokemonListResponse> {
            override fun onResponse(
                call: Call<PokemonListResponse>,
                response: Response<PokemonListResponse>
            ) {
                val pokemonResponse = response.body()!!.pokemonList
            }

            override fun onFailure(call: Call<PokemonListResponse>, t: Throwable) {
                println("No Deu")
            }
        })
    }
}
