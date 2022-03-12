package com.sourabhverma.sourabhcitsworldwide

data class Value(
    val _type: String,
    val datePublished: String,
    val description: String,
    val image: Image,
    val name: String,
    val provider: List<Provider>,
    val url: String
)