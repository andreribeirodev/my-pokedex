package com.andreribeiro.pokedextraining.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.andreribeiro.pokedextraining.R
import com.andreribeiro.pokedextraining.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // BINDING INSTANCE
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    // NAVHOST INSTANCE
    private val navHostFragment: NavHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.fragment_nav_host) as NavHostFragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(this.binding.root)
        addNavController()
    }

    private fun addNavController() {
        val navController = navHostFragment.navController
        binding.fragmentNavHost.apply {
            setupActionBarWithNavController(navController)
        }
    }
}
