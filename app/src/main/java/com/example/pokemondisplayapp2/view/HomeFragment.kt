package com.example.pokemondisplayapp2.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokemondisplayapp2.R
import com.example.pokemondisplayapp2.databinding.FragmentHomeBinding
import com.example.pokemondisplayapp2.util.FetchData
import com.example.pokemondisplayapp2.viewmodel.MainViewModel

private const val TAG = "HomeFragment"
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    lateinit var Viewmodel: MainViewModel
//    private lateinit var pokemonAdapter: PokemonAdapter
    var nextPokemonPage: Int? = null
    var prevPokemonPage: Int? = null
    var limit: Int = 20
    var offset: Int = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.inflate(layoutInflater)

        Viewmodel = ViewModelProvider(this).get(MainViewModel::class.java)
        Viewmodel.getData().observe(viewLifecycleOwner, Observer {
            binding.recyclerView.adapter = PokemonAdapter(it.results)
            binding.recyclerView.layoutManager = GridLayoutManager(requireContext(),2)

            it.next?.let {
                nextPokemonPage = FetchData.getPageOffset(it)
            }
            it.previous?.let {
                prevPokemonPage = FetchData.getPageOffset(it)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       return inflater.inflate(R.layout.fragment_home, container, false)

    }
}