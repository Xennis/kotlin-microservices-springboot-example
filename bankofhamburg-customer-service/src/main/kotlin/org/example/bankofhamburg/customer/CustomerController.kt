package org.example.bankofhamburg.customer

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class CustomerController {

    @PostMapping("/customer", consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun customer(@RequestParam("firstName") firstName: String, @RequestParam("lastName") lastName: String): ResponseEntity<String> {
        println("Hello $firstName $lastName")
        return ResponseEntity(HttpStatus.CREATED)
    }
}