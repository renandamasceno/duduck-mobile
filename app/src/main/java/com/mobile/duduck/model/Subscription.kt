package com.mobile.duduck.model

data class Subscription(
    val image: String? = null,
    val name: String? = null,
    val price: String? = null
) {
    fun exampleList(): List<Subscription> {
        return listOf(
            Subscription(
                image = null,
                name = "Spotify",
                price = "R$66,22"
            ),
            Subscription(
                image = null,
                name = "Netflix",
                price = "R$89,22"
            ),
            Subscription(
                image = null,
                name = "HBOX MAX",
                price = "R$22,22"
            ),
            Subscription(
                image = null,
                name = "Prime Video",
                price = "R$12,22"
            ),
            Subscription(
                image = null,
                name = "Disney Plus",
                price = "R$11,22"
            ),
            Subscription(
                image = null,
                name = "Start Plus",
                price = "R$10,22"
            )
        )
    }
}
