package com.fedorkin.payment.controller

import com.fedorkin.payment.model.Event
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/capture")
class Controller {

    @GetMapping("/get", produces = ["application/json"])
    fun capture(): ResponseEntity<Map<String, Any>> {
        val emptyResponse = emptyMap<String, Any>()
        return ResponseEntity(emptyResponse, HttpStatus.OK)
    }

    @PostMapping("/post", produces = ["application/json"])
    fun create(@RequestBody event: Event): ResponseEntity<Map<String, Any>> {
        println("Received event: $event")
        val emptyResponse = mapOf("1" to event.event)
        return ResponseEntity(emptyResponse, HttpStatus.OK)
    }
}