package org.project.FinanceFlow.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping({"/status", "/health"})
public class HomeController {

    @GetMapping
    public String healthcheck() {
        return "Application is running";
    }

}
