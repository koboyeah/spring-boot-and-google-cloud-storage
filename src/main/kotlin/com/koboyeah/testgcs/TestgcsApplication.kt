package com.koboyeah.testgcs

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.SpringApplication
import org.springframework.scheduling.annotation.EnableScheduling


@SpringBootApplication
@EnableScheduling
class TestgcsApplication

fun main(args: Array<String>) {
    SpringApplication.run(TestgcsApplication::class.java, *args)
}


