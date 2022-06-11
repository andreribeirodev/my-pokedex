package com.andreribeiro.pokedextraining.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreribeiro.pokedextraining.model.PokemonModel
import com.andreribeiro.pokedextraining.repository.IPokemonRepository
import kotlinx.coroutines.launch

// TODO: FAZER TRATIVAS DE ERROS DA API

class PokemonListViewModel(
    private val pokemonRepository: IPokemonRepository
) : ViewModel() {

    private val _pokemons = MutableLiveData<List<PokemonModel>>()
    val pokemons: LiveData<List<PokemonModel>> = _pokemons

    fun getPokemons(limit: Int) {
        viewModelScope.launch {
            val pokemonList = pokemonRepository.getPokemonsList(limit)
            _pokemons.postValue(pokemonList.body()?.results)
        }
    }
}
