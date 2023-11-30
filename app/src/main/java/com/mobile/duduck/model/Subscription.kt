package com.mobile.duduck.model

import com.google.gson.annotations.SerializedName

data class Subscription(
    @SerializedName("id") val id: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("image") val image: String? = null,
    @SerializedName("price") val price: Double? = null,
    @SerializedName("description") val description: String? = null
) {
    fun exampleList(): List<Subscription> {
        return listOf(
//            Subscription(
//                image = null,
//                name = "Spotify",
//                price = "R$66,22"
//            ),
//            Subscription(
//                image = null,
//                name = "Netflix",
//                price = "R$89,22"
//            ),
//            Subscription(
//                image = null,
//                name = "HBOX MAX",
//                price = "R$22,22"
//            ),
//            Subscription(
//                image = null,
//                name = "Prime Video",
//                price = "R$12,22"
//            ),
//            Subscription(
//                image = null,
//                name = "Disney Plus",
//                price = "R$11,22"
//            ),
//            Subscription(
//                image = null,
//                name = "Start Plus",
//                price = "R$10,22"
//            )
        )
    }
}
