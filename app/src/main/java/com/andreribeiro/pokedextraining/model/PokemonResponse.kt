package com.andreribeiro.pokedextraining.model

import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    @SerializedName("name")
    val pokemonName: String,
    @SerializedName("url")
    val pokemonDetailsUrl: String
)
