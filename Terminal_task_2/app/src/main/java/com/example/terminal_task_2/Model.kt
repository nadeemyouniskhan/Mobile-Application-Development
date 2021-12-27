package com.example.terminal_task_2

class Model(title: String?, product: String?, quantity: String?) {

    private var title: String
    private var product: String
    private var quantity: String
    init {
        this.title = title!!
        this.product = product!!
        this.quantity = quantity!!
    }
    fun getTitle(): String? {
        return title
    }
    fun setTitle(name: String?) {
        title = name!!
    }
    fun getQuantity(): String? {
        return quantity
    }
    fun setQuantity(quantity: String?) {
        this.quantity = quantity!!
    }
    fun getProduct(): String? {
        return product
    }
    fun setProduct(product: String?) {
        this.product = product!!
    }
}