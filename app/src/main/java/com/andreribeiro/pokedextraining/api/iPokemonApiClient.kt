package com.andreribeiro.pokedextraining.api

import com.andreribeiro.pokedextraining.model.PokemonListResponse
import com.andreribeiro.pokedextraining.utils.Constants.Companion.BASE_URL
import com.andreribeiro.pokedextraining.utils.Constants.Companion.OFF_SET
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface iPokemonApiClient {

    @GET("v2/pokemon/$OFF_SET")
    fun getPokemonsFromApi(): Call<PokemonListResponse>

    companion object {
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val pokemonService by lazy {
            retrofit.create(iPokemonApiClient::class.java)
        }
    }
}
