package com.andreribeiro.pokedextraining.api

import com.andreribeiro.pokedextraining.model.PokemonListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IPokemonClient {

    @GET("pokemon")
    suspend fun getPokemonsList(
        @Query("limit") limit: Int
    ): Response<PokemonListResponse>
}
