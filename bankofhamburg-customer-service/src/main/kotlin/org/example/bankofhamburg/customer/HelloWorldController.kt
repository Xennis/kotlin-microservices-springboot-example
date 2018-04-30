package org.example.bankofhamburg.customer

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class HelloWorldController {

    @GetMapping("/helloWorld")
    fun helloWorld(@RequestParam(value = "type", defaultValue = "pong") type: String): ResponseEntity<String> {
        return ResponseEntity("Type is $type", HttpStatus.OK)
    }
}