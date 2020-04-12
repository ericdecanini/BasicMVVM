package com.ericdecanini.basicmvvm.activity.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.ericdecanini.basicmvvm.R
import kotlinx.android.synthetic.main.fragment_main.*

class MainActivityFragment: Fragment() {

    private val viewModel: MainActivityViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
        observeDogBreed()
    }

    private fun setupClickListeners() {
        dogbreed_button.setOnClickListener { viewModel.getRandomDogBreed() }
    }

    private fun observeDogBreed() {
        viewModel.dogBreedLiveData.observe(viewLifecycleOwner, Observer { breed ->
            dogbreed_textview.text = breed
        })
    }
}