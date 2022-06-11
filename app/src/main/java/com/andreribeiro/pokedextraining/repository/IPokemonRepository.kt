package com.andreribeiro.pokedextraining.repository

import com.andreribeiro.pokedextraining.model.PokemonListResponse
import retrofit2.Response

interface IPokemonRepository {
    suspend fun getPokemonsList(limit: Int): Response<PokemonListResponse>
}
