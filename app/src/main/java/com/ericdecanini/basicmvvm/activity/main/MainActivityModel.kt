package com.ericdecanini.basicmvvm.activity.main

import com.ericdecanini.basicmvvm.repository.DogRepository

class MainActivityModel {

    val dogRepository = DogRepository()

    fun getRandomBreed(): String = dogRepository.getRandomBreed()

}