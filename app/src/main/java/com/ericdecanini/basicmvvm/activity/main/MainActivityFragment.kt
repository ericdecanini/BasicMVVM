package com.ericdecanini.basicmvvm.activity.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.ericdecanini.basicmvvm.databinding.FragmentMainBinding

class MainActivityFragment: Fragment() {

    private val viewModel: MainActivityViewModel by activityViewModels()
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
): View {
    _binding = FragmentMainBinding.inflate(inflater)
    return binding.root
}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
        observeDogBreed()
    }

    private fun setupClickListeners() {
        binding.randomize.setOnClickListener { viewModel.getRandomDogBreed() }
    }

    private fun observeDogBreed() {
        viewModel.dogBreedLiveData.observe(viewLifecycleOwner, Observer { breed ->
            binding.name.text = breed
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}