package com.worldmanager.megamind.api

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

object DemoApplication extends App {
    SpringApplication.run(classOf[DemoApplication], args: _*)
}

@SpringBootApplication
class DemoApplication {}
