package com.github.xrodrigo1982x.myapplication.model

import java.io.Serializable
import java.util.*

class Product(
        val id: String = UUID.randomUUID().toString(),
        var name: String = "",
        var description: String = "",
        var code: String = "",
        var price: Double? = 0.0,
        var rating: Int? = 0,
        var image:Int? = 0
) : Serializable