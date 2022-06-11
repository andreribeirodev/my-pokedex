package com.andreribeiro.pokedextraining.ui.fragments.pokemonlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.andreribeiro.pokedextraining.repository.PokemonRepository
import com.andreribeiro.pokedextraining.viewmodel.PokemonListViewModel

class PokemonListFactory(
    private val pokemonRepository: PokemonRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PokemonListViewModel(pokemonRepository) as T
    }
}
