package com.andreribeiro.pokedextraining.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andreribeiro.pokedextraining.model.PokemonListResponse
import com.andreribeiro.pokedextraining.model.PokemonResponse
import com.andreribeiro.pokedextraining.repository.iPokemonRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: ADICIONAR COROUTINES PARA FAZER O REQUEST RETROFIT
// TODO: FAZER TRATIVAS DE ERROS DA API

class PokemonListViewModel(
    private val pokemonRepository: iPokemonRepository
) : ViewModel() {

    private val _pokemons = MutableLiveData<List<PokemonResponse>>()
    val pokemons: LiveData<List<PokemonResponse>> = _pokemons

    fun getPokemons(limit: Int) {
        pokemonRepository.getPokemonsList(limit).enqueue(object : Callback<PokemonListResponse> {
            override fun onResponse(
                call: Call<PokemonListResponse>,
                response: Response<PokemonListResponse>
            ) {
                val result = response.body()?.results
                result.let { pokemons ->
                    _pokemons.value = pokemons
                }
            }

            override fun onFailure(call: Call<PokemonListResponse>, t: Throwable) {
                println("log não funciona mais...hahaha")
            }
        })
    }
}
