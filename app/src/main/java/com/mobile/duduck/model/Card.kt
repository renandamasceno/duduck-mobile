package com.mobile.duduck.model

import com.google.gson.annotations.SerializedName


data class Card(
    @SerializedName("id") val id: String? = null,
    @SerializedName("userId") val userId: String? = null,
    @SerializedName("nameUser") val nameUser: String? = null,
    @SerializedName("number") val number: String? = null,
    @SerializedName("expirationDate") val expirationDate: String? = null,
    @SerializedName("cardIssuer") val cardIssuer: String? = null
)
