package com.andreribeiro.pokedextraining.model

data class PokemonListResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonModel>
)
