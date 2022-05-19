package com.andreribeiro.pokedextraining.api

import com.andreribeiro.pokedextraining.model.PokemonListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface iPokemonApiClient {

    @GET("pokemon")
    fun getPokemonsListFromApi(@Query("limit") limit: Int): Call<PokemonListResponse>
}
