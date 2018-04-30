package org.example.bankofhamburg.customer

import org.assertj.core.api.Assertions.assertThat

import org.junit.Test
import org.junit.runner.RunWith

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.util.LinkedMultiValueMap
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType


@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CustomerControllerTest {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Test
    fun customerTest() {
        val requestEntity = createEntity("Jana", "Müller")
        val responseEntity = this.restTemplate.postForEntity("/customer", requestEntity, String::class.java)
        assertThat(responseEntity.statusCodeValue).isEqualTo(HttpStatus.CREATED.value())
    }

    private fun createEntity(firstName: String, lastName: String): HttpEntity<LinkedMultiValueMap<String, String>> {
        val body = LinkedMultiValueMap<String, String>()
        body.add("firstName", firstName)
        body.add("lastName", lastName)

        val headers = HttpHeaders()
        headers.contentType = MediaType.MULTIPART_FORM_DATA
        return HttpEntity(body, headers)
    }
}