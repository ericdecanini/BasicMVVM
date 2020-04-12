package com.ericdecanini.basicmvvm.repository

class DogRepository {

    private val breeds = listOf(
        "German Shepherd",
        "Bulldog",
        "Poodle",
        "Labrador Retriever",
        "Golden Retriever",
        "Beagle",
        "Yorkshire Terrier",
        "Dachshund",
        "Chihuahua"
    )

    fun getRandomBreed(): String {
        return breeds.random()
    }

}