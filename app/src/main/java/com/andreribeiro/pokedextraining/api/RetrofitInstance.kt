package com.andreribeiro.pokedextraining.api

import com.andreribeiro.pokedextraining.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object {
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val pokemonService by lazy {
            retrofit.create(iPokemonClient::class.java)
        }
    }
}
