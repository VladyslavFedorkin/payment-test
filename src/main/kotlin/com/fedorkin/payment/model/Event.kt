package com.fedorkin.payment.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Event(
    @JsonProperty("event")
    val event: String
)
