package com.andreribeiro.pokedextraining.repository

import com.andreribeiro.pokedextraining.api.iPokemonClient
import com.andreribeiro.pokedextraining.model.PokemonListResponse
import retrofit2.Call

class PokemonRepository(private val pokemonService: iPokemonClient) : iPokemonRepository {

    override fun getPokemonsList(limit: Int): Call<PokemonListResponse> {
        return pokemonService.getPokemonsListFromApi(limit)
    }
}
