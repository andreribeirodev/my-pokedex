package com.andreribeiro.pokedextraining.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.andreribeiro.pokedextraining.databinding.PokemonItemBinding
import com.andreribeiro.pokedextraining.model.PokemonModel

class AdapterPokemonList :
    ListAdapter<PokemonModel, AdapterPokemonList.PokemonListViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListViewHolder {
        val binding = PokemonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class PokemonListViewHolder(
        private val binding: PokemonItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(pokemonModel: PokemonModel) {
            binding.tvPokemonName.text = pokemonModel.name
            // todo: inserir função que retorna a imagem do pokemon
            // utilizar o Glide para processar a imagem URL
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<PokemonModel>() {

            override fun areItemsTheSame(oldItem: PokemonModel, newItem: PokemonModel): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: PokemonModel, newItem: PokemonModel): Boolean {
                return oldItem.name == newItem.name
            }
        }
    }
}
