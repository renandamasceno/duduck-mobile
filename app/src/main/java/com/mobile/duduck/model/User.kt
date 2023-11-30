package com.mobile.duduck.model

import com.google.gson.annotations.SerializedName


data class User(
    @SerializedName("id") val id: String? = null,
    @SerializedName("email") val email: String? = null,
    @SerializedName("password") val password: String? = null,
    @SerializedName("cards") val cards: List<Card> = emptyList(),
    @SerializedName("subscriptions") val subscriptions: List<Subscription> = emptyList()
)
