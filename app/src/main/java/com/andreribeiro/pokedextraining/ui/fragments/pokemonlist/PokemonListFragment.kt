package com.andreribeiro.pokedextraining.ui.fragments.pokemonlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andreribeiro.pokedextraining.R

// TODO: INSTANCIAR VIEWMODEL
// TODO: CRIAR OBSERVER PARA O REQUEST DA LISTA DE POKEMONS

class PokemonListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokemon_list, container, false)
    }
}
