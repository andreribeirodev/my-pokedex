package com.andreribeiro.pokedextraining.repository

import com.andreribeiro.pokedextraining.model.PokemonListResponse
import retrofit2.Call

interface iPokemonRepository {
    fun getPokemonsList(limit: Int): Call<PokemonListResponse>
}
