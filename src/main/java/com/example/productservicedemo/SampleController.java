package com.example.productservicedemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//This controller supports REST API's (HTTP Requests)
//the resquets coming to endpoint /hello, transger them to this controller
@RestController
@RequestMapping("/hello")
public class SampleController {

    @GetMapping("/{name}/{city}")
    public String sayHello(@PathVariable("name") String name, @PathVariable("city") String city) {
        return "Hello " + name + " from " + city;
    }
}
