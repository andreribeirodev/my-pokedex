package com.andreribeiro.pokedextraining.repository

import com.andreribeiro.pokedextraining.api.IPokemonClient
import com.andreribeiro.pokedextraining.model.PokemonListResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class PokemonRepository(private val pokemonService: IPokemonClient) : IPokemonRepository {
    override suspend fun getPokemonsList(limit: Int): Response<PokemonListResponse> {
        return withContext(Dispatchers.IO) {
            pokemonService.getPokemonsListFromApi(limit = limit)
        }
    }
}
