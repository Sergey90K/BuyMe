package com.seerhii.kurochka.buyme.network

data class ItemNet(
    val id: Int, // id
    val name: String, // first field, and first field from buy list
    val date: String, // time field
    val ownerOrDoes: String, // receiver field
    val comment: String, // description field // second field
    val amount: String, // second field
    val unit: String, // + second field
    val done: String, // done data - time
    val status: String, // status
): Comparable<ItemNet>{
    override fun compareTo(other: ItemNet): Int {
        return compareValuesBy(this, other, {it.date}, {it.unit})
    }

}
