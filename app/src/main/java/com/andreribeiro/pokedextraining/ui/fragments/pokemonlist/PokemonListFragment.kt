package com.andreribeiro.pokedextraining.ui.fragments.pokemonlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.andreribeiro.pokedextraining.api.RetrofitInstance
import com.andreribeiro.pokedextraining.databinding.FragmentPokemonListBinding
import com.andreribeiro.pokedextraining.repository.PokemonRepository
import com.andreribeiro.pokedextraining.viewmodel.PokemonListViewModel

class PokemonListFragment : Fragment() {

    private var _binding: FragmentPokemonListBinding? = null
    private val binding: FragmentPokemonListBinding get() = _binding!!

    // instancia viewModel utilizando o factory
    private val pokemonServiceApi by lazy { RetrofitInstance.pokemonService }
    private val pokemonRepository by lazy { PokemonRepository(pokemonServiceApi) }
    private val pokemonListFactory by lazy { PokemonListFactory(pokemonRepository) }
    private val mPokemonListViewModel by viewModels<PokemonListViewModel> { pokemonListFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPokemonListBinding.inflate(inflater, container, false)
        return this.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    private fun setupObservers() {
        mPokemonListViewModel.getPokemons(50)
        mPokemonListViewModel.pokemons.observe(viewLifecycleOwner) {
            binding.tvPokemonName.text = it[0].name
        }
    }
}
