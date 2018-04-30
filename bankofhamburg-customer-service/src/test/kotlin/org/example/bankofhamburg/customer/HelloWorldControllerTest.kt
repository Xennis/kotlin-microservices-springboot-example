package org.example.bankofhamburg.customer

import org.assertj.core.api.Assertions.assertThat

import org.junit.Test
import org.junit.runner.RunWith

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus


@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class HelloWorldControllerTest {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Test
    fun helloWorldTest() {
        val responseEntity = this.restTemplate.getForEntity("/helloWorld?type=fuu", String::class.java)
        assertThat(responseEntity.statusCodeValue).isEqualTo(HttpStatus.OK.value())
        assertThat(responseEntity.body).isEqualTo("Type is fuu")
    }

}