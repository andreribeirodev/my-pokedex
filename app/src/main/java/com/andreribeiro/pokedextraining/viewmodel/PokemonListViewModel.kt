package com.andreribeiro.pokedextraining.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andreribeiro.pokedextraining.model.PokemonResponse
import com.andreribeiro.pokedextraining.repository.PokemonRepository
import com.andreribeiro.pokedextraining.repository.iPokemonRepository

class pokemonListViewModel(
    private val pokemonRepository: iPokemonRepository
) : ViewModel() {

    private val _pokemons = MutableLiveData<PokemonResponse>()
    val pokemons: LiveData<PokemonResponse> = _pokemons

    fun getPokemons(limit: Int){
        pokemonRepository.getPokemonsList(limit)
    }
}
