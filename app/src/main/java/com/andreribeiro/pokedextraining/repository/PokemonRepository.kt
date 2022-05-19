package com.andreribeiro.pokedextraining.repository

import com.andreribeiro.pokedextraining.api.iPokemonApiClient
import com.andreribeiro.pokedextraining.model.PokemonListResponse
import retrofit2.Call

class PokemonRepository(private val pokemonService: iPokemonApiClient) : iPokemonRepository {

    override fun getPokemonsList(limit: Int): Call<PokemonListResponse> {
        return pokemonService.getPokemonsListFromApi(limit)
    }
}
