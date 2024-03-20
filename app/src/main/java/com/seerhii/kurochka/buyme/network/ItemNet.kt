package com.seerhii.kurochka.buyme.network

data class ItemNet(
    val name: String, // first field, and first field from buy list
    val date: String, // time field
    val ownerOrDoes: String, // receiver field
    val comment: String, // description field
    val amount: String, // second field
    val unit: String, // + second field
    
)
