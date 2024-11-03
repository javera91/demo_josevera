package com.example.demo.controller

import com.example.demo.model.Model
import com.example.demo.response.ErrorResponse
import com.example.demo.response.FailedResponse
import com.example.demo.response.SuccessResponse
import jakarta.websocket.server.PathParam
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/home")
class HomeController {

    @GetMapping()
    fun answerOne(@RequestBody model: Model): SuccessResponse {
        return SuccessResponse().apply {
            status = "success"
            data = model
        }
    }

    @GetMapping("/failed")
    fun answerTwo(@RequestBody model: Model): FailedResponse {
        return FailedResponse().apply {
            status = "failed"
            data = "El campo nombre está sin información."
        }
    }

    @GetMapping("/error")
    fun answerThree(@RequestBody model: Model): ErrorResponse {
        return ErrorResponse().apply {
            status = "error"
            data = "Se produjo un error interno en el servidor."
        }
    }
}