package com.prakriti.ecommerceapp

class EProduct {

    private var id: Int
    private var name: String
    private var price: Int
    private var image: Int // resource file

    constructor(id: Int, name: String, price: Int, image: Int) {
        this.id = id
        this.name = name
        this.price = price
        this.image = image
    }

    fun getID(): Int {
        return id
    }

    fun getName(): String {
        return name
    }

    fun getPrice(): Int {
        return price
    }

    fun getImage(): Int {
        return image
    }

}